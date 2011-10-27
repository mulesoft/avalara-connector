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

import java.math.BigDecimal;
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

import com.avalara.avatax.services.CancelTaxResult;
import com.avalara.avatax.services.GetTaxHistoryResult;
import com.avalara.avatax.services.GetTaxRequest;
import com.avalara.avatax.services.GetTaxResult;
import com.avalara.avatax.services.PingResult;
import com.avalara.avatax.services.PostTaxResult;
import com.avalara.avatax.services.SeverityLevel;
import com.avalara.avatax.services.ValidateResult;

/**
 * @author Gaston Ponti
 * @since Oct 19, 2011
 */
public class AvalaraTestDriver
{
    private AvalaraModule module;
    private Date testDate;

    /**
     * 
     */
    @Before
    public void setup()
    {
        testDate = new Date();
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
        GetTaxResult result = getTaxResultElement("Test " + Long.toString(new Date().getTime()));

        assertNotNull(result);
        assertEquals(new BigDecimal(5000), result.getTotalAmount());
    }
    
    private GetTaxResult getTaxResultElement(String docCode)
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
                put("no", "001");
                put("itemCode", "ITEM CODE 1");
                put("qty", 1);
                put("amount", 4000);
                put("discounted", false);
                put("description", "item number 1");
                put("taxIncluded", false);
            } });
            add(new HashMap<String, Object>() { {
                put("no", "002");
                put("itemCode", "ITEM CODE 1");
                put("qty", 1);
                put("amount", 1000);
                put("discounted", false);
                put("description", "item number 1");
                put("taxIncluded", false);
            } });
        } };
        
        return module.getTax("TC", AvalaraDocumentType.SALES_INVOICE, docCode, testDate,
            null, "cusomer Code", null, "0", null, null, "Origin", "Dest", addresses,
            lines, DetailLevelType.DOCUMENT, null, "Test LocationCode", false, null, 
            null, null, ServiceModeType.AUTOMATIC, new Date(), "0", testDate);
    }
    @Test
    public void testGettingPostingGettingHistoryAndCancelIt()
    {
        String docCode = "Test " + Long.toString(new Date().getTime());
        GetTaxResult taxResult = getTaxResultElement(docCode);

        assertEquals(SeverityLevel.SUCCESS, taxResult.getResultCode());

        PostTaxResult postResult = module.postTax(null, "TC", AvalaraDocumentType.SALES_INVOICE, 
            docCode, testDate, taxResult.getTotalAmount().toPlainString(), 
            taxResult.getTotalTax().toPlainString(), false, docCode);

        assertEquals(SeverityLevel.SUCCESS, postResult.getResultCode());

        //Finally Cancel Tax and remove the entry from the system by calling new DocVoided
        CancelTaxResult cancelResult = module.cancelTax(null, "TC", AvalaraDocumentType.SALES_INVOICE, docCode, CancelCodeType.DOC_VOIDED);

        assertEquals(SeverityLevel.SUCCESS, cancelResult.getResultCode());

        // Check tax history
        GetTaxHistoryResult taxHistoryResult = module.getTaxHistory(null, "TC", 
            AvalaraDocumentType.SALES_INVOICE, docCode, DetailLevelType.TAX);

        assertEquals(SeverityLevel.SUCCESS, taxHistoryResult.getResultCode());
        GetTaxRequest historyTaxRequest = taxHistoryResult.getGetTaxRequest();
        assertNotNull(historyTaxRequest);
        assertEquals(2, historyTaxRequest.getAddresses().getBaseAddress().size());
        assertEquals(2, historyTaxRequest.getLines().getLine().size());
        GetTaxResult historyTaxResult = taxHistoryResult.getGetTaxResult();
        assertNotNull(historyTaxResult);
        assertEquals(2, historyTaxResult.getTaxLines().getTaxLine().size());
        
        //Finally Cancel Tax and remove the entry from the system by calling new DocVoided
        //Delete the document from the system
        cancelResult = module.cancelTax(null, "TC", AvalaraDocumentType.SALES_INVOICE,
            docCode, CancelCodeType.DOC_DELETED);

        assertEquals(SeverityLevel.SUCCESS, cancelResult.getResultCode());
    }

    @Test
    public void validateAValidAddress() throws Exception
    {
        ValidateResult response = module.validateAddress("435 Ericksen Ave", null, null, null, "NE", null, 
            "98110", null, 0, null, null, TextCaseType.DEFAULT, false, false, new Date());
        
        assertNotNull(response);
        assertEquals("Bainbridge Island", response.getValidAddresses().getValidAddress().get(0).getCity());
    }
    
    @Test
    public void validateAnInvalidAddress() throws Exception
    {
        ValidateResult response = module.validateAddress("SARLAZA", null, null, null, null, null, 
            null, null, 0, null, null, TextCaseType.DEFAULT, false, false, new Date());
        
        assertEquals(SeverityLevel.ERROR, response.getResultCode());
    }

}
