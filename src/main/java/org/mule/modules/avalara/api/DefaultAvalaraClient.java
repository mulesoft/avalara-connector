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

import java.lang.reflect.InvocationTargetException;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPFaultException;

import org.apache.commons.lang.Validate;
import org.mule.modules.avalara.RequestType;
import org.mule.modules.avalara.exception.AvalaraRuntimeException;
import org.mule.modules.avalara.util.UsernameTokenProfile;

import com.avalara.avatax.services.BaseResult;
import com.avalara.avatax.services.GetTaxRequest;
import com.avalara.avatax.services.GetTaxResult;
import com.avalara.avatax.services.PingResult;
import com.avalara.avatax.services.SeverityLevel;
import com.avalara.avatax.services.TaxSvc;
import com.avalara.avatax.services.TaxSvcSoap;

/**
 * @author Gaston Ponti
 * @since Oct 17, 2011
 */
public class DefaultAvalaraClient implements AvalaraClient
{
    private String account;
    private String license;
    
    public DefaultAvalaraClient(String account, String license)
    {
        Validate.notEmpty(account);
        Validate.notEmpty(license);
        this.account = account;
        this.license = license;
    }

    @Override
    public PingResult ping(String message)
    {
        return getService().ping(message);
    }
    
    @Override
    public GetTaxResult getTax(GetTaxRequest getTaxRequest)
    {
        GetTaxResult response;
        try 
        {
            response = getService().getTax(getTaxRequest);
            
            if (!response.getResultCode().equals(SeverityLevel.SUCCESS))
            {
                throw new AvalaraRuntimeException(response.getMessages());
            }
            
            return response;
        }
        catch (SOAPFaultException e)
        {
           throw new AvalaraRuntimeException(e.getMessage()); 
        }
    }
    /** @see org.mule.modules.avalara.api.AvalaraClient#sendToAvalara(org.mule.modules.avalara.RequestType, java.lang.Object) */
    @Override
    public <T extends BaseResult> T sendToAvalara(RequestType entityType, Object obj)
    {
        T response;
        try
        {
            response = (T) getService().getClass().getMethod(entityType.getResourceName(), obj.getClass()).invoke(getService(), obj);
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

    /**
     * @return
     */
    public TaxSvcSoap getService()
    {
        TaxSvcSoap port = new TaxSvc().getPort(TaxSvcSoap.class);
        BindingProvider bindingProvider = (BindingProvider) port;
             
        //Headers.add(bindingProvider, profileHeaders());
        UsernameTokenProfile.sign(bindingProvider, account, license);

//        Map<String, Object> requestContext = ((BindingProvider) port).getRequestContext();
//        requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, ENDPOINT);

        return port;
    }
    
}
