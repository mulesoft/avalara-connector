/**
 * Mule Avalara Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.avalara.api;

import org.mule.modules.avalara.TaxRequestType;
import org.mule.modules.avalara.exception.AvalaraRuntimeException;
import org.mule.modules.avalara.util.AvalaraProfileHandler;

import com.avalara.avatax.services.AddressSvc;
import com.avalara.avatax.services.AddressSvcSoap;
import com.avalara.avatax.services.BaseResult;
import com.avalara.avatax.services.PingResult;
import com.avalara.avatax.services.SeverityLevel;
import com.avalara.avatax.services.TaxSvc;
import com.avalara.avatax.services.TaxSvcSoap;
import com.avalara.avatax.services.ValidateRequest;
import com.avalara.avatax.services.ValidateResult;
import com.zauberlabs.commons.ws.connection.ConnectionBuilder;
import com.zauberlabs.commons.ws.security.Credential;

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
    
    private ThreadLocal<String> usernameLocal = new ThreadLocal<String>();
    private ThreadLocal<String> passwordLocal = new ThreadLocal<String>();
    private ThreadLocal<String> clientLocal = new ThreadLocal<String>();

    @Override
    public PingResult ping(String account, String license, String client, String message)
    {
        setCredential(account, license, client);
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
    public ValidateResult validateAddress(String account, String license, String client, ValidateRequest validateRequest)
    {
        setCredential(account, license, client);
        return getAddressService().validate(validateRequest);
    }

    protected AddressSvcSoap getAddressService()
    {
        if (addressSvcSoap == null)
        {
            addressSvcSoap = createConnection(AddressSvcSoap.class, AddressSvc.class, "address", AddressSvc.AddressSvcSoap);
        }
        return addressSvcSoap;
    }

    protected TaxSvcSoap getTaxService()
    {
        if (taxSvcSoap == null)
        {
            taxSvcSoap = createConnection(TaxSvcSoap.class, TaxSvc.class, "tax", TaxSvc.TaxSvcSoap);
        }
        return taxSvcSoap;
    }
    
    protected <A> A createConnection(Class<A> portType, Class<? extends Service> serviceType, String schemaName, QName portName)
    {
        return ConnectionBuilder.fromPortType(portType)
            .withServiceType(serviceType)
            .withClasspathWsdl(schemaLocation(schemaName))
            .withCredential(new Credential()
            {
                @Override
                public String getUsername()
                {
                    return usernameLocal.get();
                }
                
                @Override
                public String getPassword()
                {
                    return passwordLocal.get();
                }
            })
            .withHeader(new AvalaraProfileHandler(new AvalaraProfile(){
                @Override
                public String getClient()
                {
                    return clientLocal.get();
                }
            }))
            .withPortQName(portName)
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

}
