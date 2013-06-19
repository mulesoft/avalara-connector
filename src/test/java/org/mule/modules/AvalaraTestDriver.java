/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.mule.api.ConnectionException;
import org.mule.modules.avalara.AvalaraDocumentType;
import org.mule.modules.avalara.AvalaraModule;
import org.mule.modules.avalara.BatchType;
import org.mule.modules.avalara.CancelCodeType;
import org.mule.modules.avalara.DetailLevelType;
import org.mule.modules.avalara.ServiceModeType;
import org.mule.modules.avalara.TextCaseType;
import org.mule.modules.avalara.api.MapBuilder;

import com.avalara.avatax.services.AdjustTaxResult;
import com.avalara.avatax.services.BatchFileFetchResult;
import com.avalara.avatax.services.BatchSaveResult;
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
public class AvalaraTestDriver {
    private AvalaraModule module;
    private XMLGregorianCalendar testDate;
    private final String ACCOUNT = ""; // FILL WITH YOUR ACCOUNT
    private final String LICENSE = ""; // FILL WITH YOUR LICENSE
    private final String CLIENT = ""; // FILL WITH A CLIENT FROM YOUR ACCOUNT

    @Before
    public void setup() throws DatatypeConfigurationException, ConnectionException {
        testDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
        module = new AvalaraModule();
        module.setAddressServiceEndpoint("https://development.avalara.net/Address/AddressSvc.asmx");
        module.setBatchServiceEndpoint("https://development.avalara.net/Batch/BatchSvc.asmx");
        module.setTaxServiceEndpoint("https://development.avalara.net/Tax/TaxSvc.asmx");
        module.connect(ACCOUNT, CLIENT, LICENSE);
    }

    @Test
    public void ping() {
        PingResult result = module.ping("Hi");
        assertNotNull(result);
        assertEquals(SeverityLevel.SUCCESS, result.getResultCode());
    }
    
    @Test
    public void pingWithCredentials() {
    	String pingAccount = ACCOUNT; // FILL WITH A SPECIFIC ACCOUNT (Module account is used here as default)
    	String pingLicense = LICENSE; // FILL WITH A SPECIFIC LICENSE (Module license is used here as default)
    	String pingAvalaraClient = CLIENT; // FILL WITH A SPECIFIC CLIENT FROM YOUR ACCOUNT (Module client is used here as default)
    	
        PingResult result = module.pingWithCredentials(pingAccount, pingAvalaraClient, pingLicense, "Hi");
        assertNotNull(result);
        assertEquals(SeverityLevel.SUCCESS, result.getResultCode());
    }

    @Test
    public void getTaxWithoutKnowingUsernameOrPassword() throws Exception {
        GetTaxResult result = getTaxResultElement("Test " + Long.toString(new Date().getTime()));

        assertNotNull(result);
        assertEquals(new BigDecimal(5000), result.getTotalAmount());
    }

    private GetTaxResult getTaxResultElement(String docCode) {
        @SuppressWarnings("serial")
        List<Map<String, Object>> addresses = new ArrayList<Map<String, Object>>() {
            {
                add(new MapBuilder()
                        .with("addressCode", "Origin")
                        .with("line1", "Avalara")
                        .with("line2", "900 Winslow Way")
                        .with("line3", "Suite 100")
                        .with("city", "Bainbridge Island")
                        .with("region", "WA")
                        .with("postalCode", "98110")
                        .with("country", "USA")
                        .build());
                add(new MapBuilder()
                        .with("addressCode", "Dest")
                        .with("line1", "3130 Elliott")
                        .with("city", "Seattle")
                        .with("region", "WA")
                        .with("postalCode", "98121")
                        .with("country", "USA")
                        .build());
            }
        };

        @SuppressWarnings("serial")
        List<Map<String, Object>> lines = new ArrayList<Map<String, Object>>() {
            {
                add(new MapBuilder()
                        .with("no", "001")
                        .with("itemCode", "ITEM CODE 1")
                        .with("qty", 1)
                        .with("amount", 4000)
                        .with("discounted", false)
                        .with("description", "item number 1")
                        .with("taxIncluded", false)
                        .build());
                add(new MapBuilder()
                        .with("no", "002")
                        .with("itemCode", "ITEM CODE 1")
                        .with("qty", 1)
                        .with("amount", 1000)
                        .with("discounted", false)
                        .with("description", "item number 1")
                        .with("taxIncluded", false)
                        .build());
            }
        };

        return module.getTax("TC", AvalaraDocumentType.SALES_INVOICE, docCode, testDate,
                null, "cusomer Code", null, "0", null, null, "Origin", "Dest", addresses,
                lines, DetailLevelType.DOCUMENT, null, "Test LocationCode", false, null,
                null, null, ServiceModeType.AUTOMATIC, testDate, "0", testDate);
    }

    private AdjustTaxResult adjustTax(String docCode) {
        @SuppressWarnings("serial")
        List<Map<String, Object>> addresses = new ArrayList<Map<String, Object>>() {
            {
                add(new MapBuilder()
                        .with("addressCode", "Origin")
                        .with("line1", "Avalara")
                        .with("line2", "900 Winslow Way")
                        .with("line3", "Suite 100")
                        .with("city", "Bainbridge Island")
                        .with("region", "WA")
                        .with("postalCode", "98110")
                        .with("country", "USA")
                        .build());
                add(new MapBuilder()
                        .with("addressCode", "Dest")
                        .with("line1", "3130 Elliott")
                        .with("city", "Seattle")
                        .with("region", "WA")
                        .with("postalCode", "98121")
                        .with("country", "USA")
                        .build());
            }
        };

        @SuppressWarnings("serial")
        List<Map<String, Object>> lines = new ArrayList<Map<String, Object>>() {
            {
                add(new MapBuilder()
                        .with("no", "001")
                        .with("itemCode", "ITEM CODE 1")
                        .with("qty", 1)
                        .with("amount", 4000)
                        .with("discounted", false)
                        .with("description", "item number 1")
                        .with("taxIncluded", false)
                        .build());
                add(new MapBuilder()
                        .with("no", "002")
                        .with("itemCode", "ITEM CODE 1")
                        .with("qty", 1)
                        .with("amount", 1000)
                        .with("discounted", false)
                        .with("description", "item number 1")
                        .with("taxIncluded", false)
                        .build());
            }
        };

        return module.adjustTax(1, "some reason", "TC", AvalaraDocumentType.SALES_INVOICE, docCode, testDate,
                null, "cusomer Code", null, "0", null, null, "Origin", "Dest", addresses,
                lines, DetailLevelType.DOCUMENT, null, "Test LocationCode", false, null,
                null, null, ServiceModeType.AUTOMATIC, testDate, "0", testDate);
    }

    @Test
    public void testGettingPostingGettingHistoryAndCancelIt() {
        String docCode = "Test " + Long.toString(new Date().getTime());
        GetTaxResult taxResult = getTaxResultElement(docCode);


        assertEquals(SeverityLevel.SUCCESS, taxResult.getResultCode());

        AdjustTaxResult adjustTaxResult = adjustTax(docCode);

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
    public void validateAValidAddress() throws Exception {
        ValidateResult response = module.validateAddress("435 Ericksen Ave", null, null, null, "NE", null,
                "98110", null, 0, null, null, TextCaseType.DEFAULT, false, false, testDate);

        assertNotNull(response);
        assertEquals("Bainbridge Island", response.getValidAddresses().getValidAddress().get(0).getCity());
    }

    @Test
    public void validateAnInvalidAddress() throws Exception {
        ValidateResult response = module.validateAddress("SARLAZA", null, null, null, null, null,
                null, null, 0, null, null, TextCaseType.DEFAULT, false, false, testDate);

        assertEquals(SeverityLevel.ERROR, response.getResultCode());
    }

    @Test
    public void saveBatchFile() throws Exception {
        String fileString = "ProcessCode,DocCode,DocType,DocDate,CompanyCode,CustomerCode,EntityUseCode,LineNo,TaxCode,TaxDate,ItemCode,Description,Qty,Amount,Discount,Ref1,Ref2,ExemptionNo,RevAcct,DestAddress,DestCity,DestRegion,DestPostalCode,DestCountry,OrigAddress,OrigCity,OrigRegion,OrigPostalCode,OrigCountry,LocationCode,SalesPersonCode,PurchaseOrderNo,CurrencyCode,ExchangeRate,ExchangeRateEffDate,PaymentDate,TaxIncluded,DestTaxRegion,OrigTaxRegion,Taxable,TaxType,TotalTax,CountryName,CountryCode,CountryRate,CountryTax,StateName,StateCode,StateRate,StateTax,CountyName,CountyCode,CountyRate,CountyTax,CityName,CityCode,CityRate,CityTax,Other1Name,Other1Code,Other1Rate,Other1Tax,Other2Name,Other2Code,Other2Rate,Other2Tax,Other3Name,Other3Code,Other3Rate,Other3Tax,Other4Name,Other4Code,Other4Rate,Other4Tax,ReferenceCode\n" +
                "3,INV00000137,3,2012-11-06,TC,A00000001,,2c92c0943aaaf3bf013add2b74db437a,,2012-11-06,Mule iON,,1,20,,2c92c0943aaaf3bf013add2b74db437a,2c92c0943aaaf3bf013add2b74c24378,,,30 Maiden Ln,San Francisco,California,94108-5429,United States,,,,,,,,,USD,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,";

        BatchSaveResult saveResult = module.saveBatch(BatchType.TRANSACTION_IMPORT, 156785, fileString, "filenr004");
        assertEquals(SeverityLevel.SUCCESS, saveResult.getResultCode());
        assertNotNull(saveResult.getBatchId());
        assertNotNull(saveResult.getEstimatedCompletion());
    }

    @Test
    public void fetchBatch() throws Exception {
        // FIXME: Not sure what's the deal with this test...
        Map<String, BatchFileFetchResult> fetchResult = module.fetchBatchFile("129275");
        assertEquals(1, fetchResult.get("result").getBatchFiles().getBatchFile().size());
        System.out.println(new String(fetchResult.get("result").getBatchFiles().getBatchFile().get(0).getContent()));
        assertEquals(1, fetchResult.get("error").getBatchFiles().getBatchFile().size());
        System.out.println(new String(fetchResult.get("error").getBatchFiles().getBatchFile().get(0).getContent()));
    }

    @Test
    public void isBatchFinished() throws Exception {
        boolean isFinished = module.isBatchFinished("129275");
        assertTrue(isFinished);
    }
}
