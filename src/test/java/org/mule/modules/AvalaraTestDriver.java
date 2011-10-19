/*
 * Copyright (c) 2011 Zauber S.A.  -- All rights reserved
 */

package org.mule.modules;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mule.modules.avalara.AvalaraDocumentType;
import org.mule.modules.avalara.AvalaraModule;
import org.mule.modules.avalara.DetailLevelType;
import org.mule.modules.avalara.ServiceModeType;

/**
 * @author Gaston Ponti
 * @since Oct 19, 2011
 */

public class AvalaraTestDriver
{
    public AvalaraModule module;
    
    /**
     * 
     */
    @Before
    public void setup()
    {
        module = new AvalaraModule();       
        module.init();
    }

    @Test
    public void getTaxWithoutKnowingUsernameOrPassword() throws Exception
    {
//        new TaxSvc().getTaxSvcSoap().getTax(new GetTaxRequest());
        
        module.getTax("FOO",
            AvalaraDocumentType.SALES_ORDER, null,
            new Date(), null, null, null,
            "1.2", null, null, null, null, null, null,
            DetailLevelType.TAX, null,
            28, null,
            false, null, null, null,
            ServiceModeType.LOCAL,
            new Date(),
            "2.3",
            new Date());
        
        
    }
}
