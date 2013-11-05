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
import org.mule.modules.avalara.AddressRequestType;
import org.mule.modules.avalara.BatchRequestType;
import org.mule.modules.avalara.RequestType;
import org.mule.modules.avalara.TaxRequestType;
import org.mule.modules.avalara.exception.AvalaraAuthenticationException;
import org.mule.modules.avalara.exception.AvalaraRuntimeException;
import org.mule.modules.avalara.util.AvalaraProfileHandler;

import com.zauberlabs.commons.ws.connection.ConnectionBuilder;
import com.zauberlabs.commons.ws.security.BasicCredential;

import java.lang.reflect.InvocationTargetException;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPFaultException;

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
    
    private final String account;
    private final String license;
    private final String client;

    public DefaultAvalaraClient(String account, String client, String license) {
        Validate.notNull(account);
        Validate.notNull(client);
        Validate.notNull(license);
        this.account = account;
        this.client = client;
        this.license = license;
    }

    public DefaultAvalaraClient(String account, String client, String license, String addressEndpoint, String taxEndpoint) {
        Validate.notNull(addressEndpoint);
        Validate.notNull(taxEndpoint);
        Validate.notNull(account);
        Validate.notNull(client);
        Validate.notNull(license);
        this.setAddressEndpoint(addressEndpoint);
        this.setTaxEndpoint(taxEndpoint);
        this.account = account;
        this.client = client;
        this.license = license;
    }

    @Override
    public PingResult ping(String message) {
    	String messageToSend = "";
    	if(message != null) {
    		messageToSend = message;
    	}
        return this.sendTaxRequestToAvalara(TaxRequestType.Ping, messageToSend);
    }

    protected <T extends BaseResult> T sendRequestToAvalara(Object service, RequestType entityType, Object obj) {
    	T response;

        try {
            response = (T) service.getClass().getMethod(entityType.getResourceName(), obj.getClass()).invoke(service, obj);
        }
        catch (InvocationTargetException e) {
        	Throwable cause = e.getCause();
        	
        	if (this.isAvalaraAuthenticationException(cause)) {
        		throw new AvalaraAuthenticationException(cause.getMessage());
        	}
        	
            throw new AvalaraRuntimeException(cause.getMessage());
        }
        catch (Exception e) {
            throw new AssertionError(e);
        }
        if (!response.getResultCode().equals(SeverityLevel.SUCCESS)) {
            throw new AvalaraRuntimeException(response.getMessages());
        }
        return response;
    }
    
    protected Boolean isAvalaraAuthenticationException(Throwable e){
    	return e instanceof SOAPFaultException && e.getMessage().contains("The user or account could not be authenticated");
    }
    
    @Override
    public <T extends BaseResult> T sendTaxRequestToAvalara(TaxRequestType entityType, Object obj) {
    	return this.sendRequestToAvalara(getTaxService(), entityType, obj);
    }
    
    @Override
    public <T extends BaseResult> T sendAddressRequestToAvalara(AddressRequestType entityType, Object obj) {
    	return this.sendRequestToAvalara(getAddressService(), entityType, obj);
    }
    
    @Override
    public <T extends BaseResult> T sendBatchRequestToAvalara(BatchRequestType entityType, Object obj) {
    	return this.sendRequestToAvalara(getBatchService(), entityType, obj);
    }
    
    @Override
    public BatchFetchResult fetchBatch(FetchRequest fetchRequest) {
        return this.sendBatchRequestToAvalara(BatchRequestType.BatchFetch, fetchRequest);
    }

    @Override
    public BatchFileFetchResult fetchBatchFile(FetchRequest fetchRequest) {
    	return this.sendBatchRequestToAvalara(BatchRequestType.BatchFileFetch, fetchRequest);
    }

    @Override
    public BatchSaveResult saveBatch(Batch batch) {
    	return this.sendBatchRequestToAvalara(BatchRequestType.BatchSave, batch);
    }
    
    public String getAccount() {
        return this.account;
    }

    public String getLicense() {
        return this.license;
    }

    public String getClient() {
        return this.client;
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
            .withCredential(new BasicCredential(this.getAccount() ,this.getLicense()))
            .withHeader(new AvalaraProfileHandler(this.getClient()))
            .withPortQName(portName)
            .withEndpoint(endpoint)
            .build();
    }

    protected String schemaLocation(String schemaName)
    {
        return "schema/" + schemaName + "svc.wsdl";
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

    @Override
    public String getConnectionIdentifier() {
        return this.account + "-" + this.client;
    }

}
