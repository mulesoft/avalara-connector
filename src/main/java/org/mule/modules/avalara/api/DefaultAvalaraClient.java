/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.avalara.api;

import com.avalara.avatax.services.*;
import org.apache.commons.lang.Validate;
import org.mule.modules.avalara.TaxRequestType;
import org.mule.modules.avalara.exception.AvalaraRuntimeException;
import org.mule.modules.avalara.util.AvalaraProfileHandler;

import com.zauberlabs.commons.ws.connection.ConnectionBuilder;
import com.zauberlabs.commons.ws.security.BasicCredential;

import java.lang.reflect.InvocationTargetException;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 * @author Gaston Ponti
 * @since Oct 17, 2011
 */
public class DefaultAvalaraClient implements AvalaraClient
{
    private TaxSvcSoap taxSvcSoap;
    private AddressSvcSoap addressSvcSoap;
    private BatchSvcSoap batchSvcSoap;

    private String addressEndpoint;
    private String taxEndpoint;
    private String batchEndpoint;
    
    private ThreadLocal<String> usernameLocal = new ThreadLocal<String>();
    private ThreadLocal<String> passwordLocal = new ThreadLocal<String>();
    private ThreadLocal<String> clientLocal = new ThreadLocal<String>();

    public DefaultAvalaraClient(String account, String client, String license) {
        Validate.notNull(account);
        Validate.notNull(client);
        Validate.notNull(license);
        setCredential(account, license, client); //FIXME: temp impl. Set credential won't be used anymore
    }

    public DefaultAvalaraClient(String account, String client, String license, String addressEndpoint, String taxEndpoint) {
        Validate.notNull(addressEndpoint);
        Validate.notNull(taxEndpoint);
        Validate.notNull(account);
        Validate.notNull(client);
        Validate.notNull(license);
        this.setAddressEndpoint(addressEndpoint);
        this.setTaxEndpoint(taxEndpoint);
        setCredential(account, license, client); //FIXME: temp impl. Set credential won't be used anymore
    }

    @Override
    public PingResult ping(String message) {
        return getTaxService().ping(message);
    }

    /** @see org.mule.modules.avalara.api.AvalaraClient#sendToAvalara(org.mule.modules.avalara.TaxRequestType, java.lang.Object) */
    @Override
    public <T extends BaseResult> T sendToAvalara(String account, String license, String client, TaxRequestType entityType, Object obj)
    {
        T response;
        setCredential(account, license, client);

        try
        {

            response = (T) getTaxService().getClass().getMethod(entityType.getResourceName(), obj.getClass()).invoke(getTaxService(), obj);

        }
        catch (InvocationTargetException e)
        {
            throw new AvalaraRuntimeException(e.getCause().getMessage());
        }
        catch (Exception e)
        {
            throw new AssertionError(e);
        }
        if (!response.getResultCode().equals(SeverityLevel.SUCCESS))
        {
            throw new AvalaraRuntimeException(response.getMessages());
        }
        return response;
    }

    @Override
    public ValidateResult validateAddress(ValidateRequest validateRequest) {
        return getAddressService().validate(validateRequest);
    }

    @Override
    public BatchFetchResult fetchBatch(FetchRequest fetchRequest) {
        return getBatchService().batchFetch(fetchRequest);
    }

    @Override
    public BatchFileFetchResult fetchBatchFile(FetchRequest fetchRequest) {
        return getBatchService().batchFileFetch(fetchRequest);
    }

    @Override
    public BatchSaveResult saveBatch(String account, String license, String client, Batch batch)
    {
        setCredential(account, license, client);
        return getBatchService().batchSave(batch);
    }
    
    public String getUsername()
    {
        return usernameLocal.get();
    }

    public String getPassword()
    {
        return passwordLocal.get();
    }

    public String getClient()
    {
        return clientLocal.get();
    }

    protected AddressSvcSoap getAddressService()
    {
        if (addressSvcSoap == null)
        {
            addressSvcSoap = createConnection(AddressSvcSoap.class, AddressSvc.class, "address", AddressSvc.AddressSvcSoap, getAddressEndpoint());
        }
        return addressSvcSoap;
    }

    protected BatchSvcSoap getBatchService()
    {
        if (batchSvcSoap == null)
        {
            batchSvcSoap = createConnection(BatchSvcSoap.class, BatchSvc.class, "batch", BatchSvc.BatchSvcSoap, getBatchEndpoint());
        }
        return batchSvcSoap;
    }

    protected TaxSvcSoap getTaxService()
    {
        if (taxSvcSoap == null)
        {
            taxSvcSoap = createConnection(TaxSvcSoap.class, TaxSvc.class, "tax", TaxSvc.TaxSvcSoap, getTaxEndpoint());

        }
        return taxSvcSoap;
    }
    
    protected <A> A createConnection(Class<A> portType, Class<? extends Service> serviceType, String schemaName, QName portName, String endpoint) {
        return ConnectionBuilder.fromPortType(portType)
            .withServiceType(serviceType)
            .withClasspathWsdl(schemaLocation(schemaName))
            .withCredential(new BasicCredential(usernameLocal.get(),passwordLocal.get()))
            .withHeader(new AvalaraProfileHandler(clientLocal.get()))
            .withPortQName(portName)
            .withEndpoint(endpoint)
            .build();
    }

    protected String schemaLocation(String schemaName)
    {
        return "schema/" + schemaName + "svc.wsdl";
    }
    
    protected void setCredential(String account, String license, String client)
    {
        usernameLocal.set(account);
        passwordLocal.set(license);
        clientLocal.set(client);
    }

    public String getAddressEndpoint() {
        return addressEndpoint;
    }

    public String getBatchEndpoint() {
        return batchEndpoint;
    }

    public void setAddressEndpoint(String addressEndpoint) {
        this.addressEndpoint = addressEndpoint;
    }

    public String getTaxEndpoint() {
        return taxEndpoint;
    }

    public void setTaxEndpoint(String taxEndpoint) {
        this.taxEndpoint = taxEndpoint;
    }

}
