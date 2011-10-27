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

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.mule.modules.avalara.TaxRequestType;
import org.mule.modules.avalara.exception.AvalaraRuntimeException;
import org.mule.modules.avalara.util.AvalaraProfileHeader;
import org.mule.modules.avalara.util.UsernameTokenProfile;

import com.avalara.avatax.services.AddressSvc;
import com.avalara.avatax.services.AddressSvcSoap;
import com.avalara.avatax.services.BaseResult;
import com.avalara.avatax.services.PingResult;
import com.avalara.avatax.services.SeverityLevel;
import com.avalara.avatax.services.TaxSvc;
import com.avalara.avatax.services.TaxSvcSoap;
import com.avalara.avatax.services.ValidateRequest;
import com.avalara.avatax.services.ValidateResult;

/**
 * @author Gaston Ponti
 * @since Oct 17, 2011
 */
public class DefaultAvalaraClient implements AvalaraClient
{
    private String account;
    private String license;
    private String client;
    private TaxSvcSoap taxSvcSoap;
    private AddressSvcSoap addressSvcSoap;
    
    public DefaultAvalaraClient(String account, String license, String client)
    {
        Validate.notEmpty(account);
        Validate.notEmpty(license);
        Validate.notEmpty(client);
        this.account = account;
        this.license = license;
        this.client = client;
    }

    @Override
    public PingResult ping(String message)
    {
        return getService().ping(message);
    }
    
    /** @see org.mule.modules.avalara.api.AvalaraClient#sendToAvalara(org.mule.modules.avalara.TaxRequestType, java.lang.Object) */
    @Override
    public <T extends BaseResult> T sendToAvalara(TaxRequestType entityType, Object obj)
    {
        System.out.println(ToStringBuilder.reflectionToString(obj));
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

    @Override
    public ValidateResult validateAddress(ValidateRequest validateRequest)
    {
        if (addressSvcSoap == null)
        {
            addressSvcSoap = new AddressSvc().getPort(AddressSvcSoap.class);
        
            UsernameTokenProfile.sign((BindingProvider) addressSvcSoap, account, license);
            AvalaraProfileHeader.sign((BindingProvider) addressSvcSoap, client);
        }
        
        return addressSvcSoap.validate(validateRequest);
    }
    
    /**
     * @return
     */
    public TaxSvcSoap getService()
    {
        if (taxSvcSoap == null)
        {
            taxSvcSoap = new TaxSvc().getPort(TaxSvcSoap.class);
            BindingProvider bindingProvider = (BindingProvider) taxSvcSoap;
             
            UsernameTokenProfile.sign(bindingProvider, account, license);
            AvalaraProfileHeader.sign(bindingProvider, client);
        }
        
        return taxSvcSoap;
    }
}
