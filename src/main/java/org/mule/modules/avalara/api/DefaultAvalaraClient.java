
/*
 * Copyright (c) 2011 Zauber S.A.  -- All rights reserved
 */

package org.mule.modules.avalara.api;

import org.mule.modules.avalara.EntityType;
import org.mule.modules.avalara.exception.AvalaraRuntimeException;

import com.avalara.avatax.services.BaseResult;
import com.avalara.avatax.services.SeverityLevel;
import com.avalara.avatax.services.TaxSvc;
import com.avalara.avatax.services.TaxSvcSoap;


/**
 * @author Gaston Ponti
 * @since Oct 17, 2011
 */

public class DefaultAvalaraClient implements AvalaraClient
{
    private TaxSvcSoap taxSvcSoap;
    
    public DefaultAvalaraClient(String username, String password)
    {
        taxSvcSoap = new TaxSvc().getTaxSvcSoap();
    }

    /** @see org.mule.modules.avalara.api.AvalaraClient#sendToAvalara(org.mule.modules.avalara.EntityType, java.lang.Object) */
    @Override
    public <T extends BaseResult> T sendToAvalara(EntityType entityType, Object obj)
    {
        T response;
        try
        {
            response = (T) taxSvcSoap.getClass().getMethod(entityType.getResourceName(), obj.getClass()).invoke(taxSvcSoap, obj);
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
    
}
