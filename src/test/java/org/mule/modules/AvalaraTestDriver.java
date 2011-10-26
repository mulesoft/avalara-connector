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

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mule.modules.avalara.AvalaraDocumentType;
import org.mule.modules.avalara.AvalaraModule;
import org.mule.modules.avalara.CancelCodeType;
import org.mule.modules.avalara.DetailLevelType;
import org.mule.modules.avalara.ServiceModeType;
import org.mule.modules.avalara.TextCaseType;
import org.mule.modules.avalara.exception.AvalaraRuntimeException;

import com.avalara.avatax.services.CancelTaxResult;
import com.avalara.avatax.services.CommitTaxResult;
import com.avalara.avatax.services.GetTaxResult;
import com.avalara.avatax.services.PingResult;
import com.avalara.avatax.services.SeverityLevel;
import com.avalara.avatax.services.ValidateResult;

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
        module.setAccount(System.getenv("avalaraAccount"));
        module.setLicense(System.getenv("avalaraLicense"));
        module.setAvalaraClient(System.getenv("avalaraClient"));
        module.init();
    }

    @Test
    public void ping()
    {
        PingResult result = module.ping("Hi");
        assertNotNull(result);
        assertEquals(SeverityLevel.SUCCESS, result.getResultCode());
    }

    @Test
    public void getTaxWithoutKnowingUsernameOrPassword() throws Exception
    {
        List<Map<String, Object>> addresses = new ArrayList<Map<String, Object>>() { {
            add(new HashMap<String, Object>() { {
                put("addressCode", "Origin");
                put("line1", "Avalara");
                put("line2", "900 Winslow Way");
                put("line3", "Suite 100");
                put("city", "Bainbridge Island");
                put("region", "WA");
                put("postalCode", "98110");
                put("country", "USA");
            } });
            add(new HashMap<String, Object>() { {
                put("addressCode", "Dest");
                put("line1", "3130 Elliott");
                put("city", "Seattle");
                put("region", "WA");
                put("postalCode", "98121");
                put("country", "USA");
            } });
        } };
        
        List<Map<String, Object>> lines = new ArrayList<Map<String, Object>>() { {
            add(new HashMap<String, Object>() { {
                put("no", "666");
                put("itemCode", "ITEM CODE 1");
                put("qty", 42.4);
                put("amount", 4);
                put("discounted", false);
                put("description", "item number 1");
                put("taxIncluded", false);
            } });
        } };
        
        GetTaxResult result = module.getTax("TC", AvalaraDocumentType.SALES_ORDER, "1234", new Date(), null,
            "cusomer Code", null, "1.2", null, null, "Origin", "Dest", addresses, lines, DetailLevelType.TAX, null, null,
            false, null, null, null, ServiceModeType.LOCAL, new Date(), "2.3", new Date());

        assertNotNull(result);
        assertEquals("1234", result.getDocCode());
    }

    @Test
    public void createCommitAndCancelATax() throws Exception
    {
        List<Map<String, Object>> addresses = new ArrayList<Map<String, Object>>() { {
            add(new HashMap<String, Object>() { {
                put("addressCode", "Origin");
                put("line1", "Avalara");
                put("line2", "900 Winslow Way");
                put("line3", "Suite 100");
                put("city", "Bainbridge Island");
                put("region", "WA");
                put("postalCode", "98110");
                put("country", "USA");
            } });
            add(new HashMap<String, Object>() { {
                put("addressCode", "Dest");
                put("line1", "3130 Elliott");
                put("city", "Seattle");
                put("region", "WA");
                put("postalCode", "98121");
                put("country", "USA");
            } });
        } };
        
        List<Map<String, Object>> lines = new ArrayList<Map<String, Object>>() { {
            add(new HashMap<String, Object>() { {
                put("no", "666");
                put("itemCode", "ITEM CODE 1");
                put("qty", 42.4);
                put("amount", 4);
                put("discounted", false);
                put("description", "item number 1");
                put("taxIncluded", false);
            } });
        } };
        
        GetTaxResult getTaxResult = module.getTax("TC", AvalaraDocumentType.SALES_ORDER, "1_45_45670", new Date(), null, "testCustomer", null,
            "1.2", null, null, "Origin", "Dest", addresses, lines, DetailLevelType.TAX, null, null, false, null,
            null, null, ServiceModeType.LOCAL, new Date(), "2.3", new Date());

        CommitTaxResult commitTaxResult = module.commitTax(getTaxResult.getDocId(), "TC", AvalaraDocumentType.SALES_ORDER,
            getTaxResult.getDocCode(), "1_45_45671");

        assertNotNull(commitTaxResult);

        CancelTaxResult cancelTaxResult = module.cancelTax(null, "TC", AvalaraDocumentType.SALES_ORDER,
            "1_45_45671", CancelCodeType.DOC_DELETED);

        assertEquals(commitTaxResult.getDocId() , cancelTaxResult.getDocId());
    }
    
    @Test
    public void validateAValidAddress() throws Exception
    {
        ValidateResult response = module.validateAddress("435 Ericksen Ave", null, null, null, "NE", null, 
            "98110", null, 0, null, null, TextCaseType.DEFAULT, false, false, new Date());
        
        assertNotNull(response);
        assertEquals("Bainbridge Island", response.getValidAddresses().getValidAddress().get(0).getCity());
    }
    
    @Test(expected = AvalaraRuntimeException.class)
    public void validateAnInvalidAddress() throws Exception
    {
        ValidateResult response = module.validateAddress("SARLAZA", null, null, null, null, null, 
            null, null, 0, null, null, TextCaseType.DEFAULT, false, false, new Date());
    }

}
