
/*
 * Copyright (c) 2011 Zauber S.A.  -- All rights reserved
 */

package org.mule.modules.avalara.api;

import java.lang.reflect.InvocationTargetException;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPFaultException;

import org.mule.modules.avalara.EntityType;
import org.mule.modules.avalara.exception.AvalaraRuntimeException;
import org.mule.modules.avalara.util.SOAPSimpleCredentials;

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
    private String username;
    private String password;
    
    public DefaultAvalaraClient(String username, String password)
    {
        this.username = username;
        this.password = password;
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
    /** @see org.mule.modules.avalara.api.AvalaraClient#sendToAvalara(org.mule.modules.avalara.EntityType, java.lang.Object) */
    @Override
    public <T extends BaseResult> T sendToAvalara(EntityType entityType, Object obj)
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
        SOAPSimpleCredentials.addSOAPSimpleCredentials(((BindingProvider) port), username, password);

//        Map<String, Object> requestContext = ((BindingProvider) port).getRequestContext();
//        requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, ENDPOINT);

        return port;
    }
    
}
