/**
 * Mule Avalara Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mule.modules.avalara.AvalaraDocumentType;
import org.mule.modules.avalara.AvalaraModule;
import org.mule.modules.avalara.CancelCodeType;
import org.mule.modules.avalara.DetailLevelType;
import org.mule.modules.avalara.ServiceModeType;

import com.avalara.avatax.services.CancelTaxResult;
import com.avalara.avatax.services.CommitTaxResult;
import com.avalara.avatax.services.GetTaxResult;
import com.avalara.avatax.services.PingResult;

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
        module.setUsername(System.getenv("avalaraUsername"));
        module.setPassword(System.getenv("avalaraPassword"));
        module.init();
    }

    @Test
    public void ping()
    {
        PingResult result = module.ping("Hi");
        assertNotNull(result);
        assertFalse(result.getMessages().getMessage().isEmpty());
        assertEquals("Hi", result.getMessages().getMessage().get(0));
    }

    @Test
    public void getTaxWithoutKnowingUsernameOrPassword() throws Exception
    {
        // new TaxSvc().getTaxSvcSoap().getTax(new GetTaxRequest());

        GetTaxResult result = module.getTax("FOO", AvalaraDocumentType.SALES_ORDER, "1234", new Date(), null,
            null, null, "1.2", null, null, null, null, null, null, DetailLevelType.TAX, null, 28, null,
            false, null, null, null, ServiceModeType.LOCAL, new Date(), "2.3", new Date());

        assertNotNull(result);
        assertEquals("some code", result.getDocCode());
    }

    @Test
    public void createCommitAndCancelATax() throws Exception
    {

        module.getTax("FOO", AvalaraDocumentType.SALES_ORDER, "1_45_45670", new Date(), null, null, null,
            "1.2", null, null, null, null, null, null, DetailLevelType.TAX, null, 28, null, false, null,
            null, null, ServiceModeType.LOCAL, new Date(), "2.3", new Date());

        CommitTaxResult commitTaxResult = module.commitTax("docId", "FOO", AvalaraDocumentType.SALES_ORDER,
            "1_45_45670", "1_45_45671");

        assertNotNull(commitTaxResult);

        CancelTaxResult cancelTaxResult = module.cancelTax("docId", "FOO", AvalaraDocumentType.SALES_ORDER,
            "1_45_45671", CancelCodeType.DOC_DELETED);

        assertEquals("docId", cancelTaxResult.getDocId());
    }

}
