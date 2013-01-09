/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules;

import com.avalara.avatax.services.*;
import org.junit.Before;
import org.junit.Test;
import org.mule.modules.avalara.*;
import org.mule.modules.avalara.api.AvalaraClient;
import org.mule.modules.avalara.api.DefaultAvalaraClient;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Gaston Ponti
 * @since Oct 19, 2011
 */
public class AvalaraTestDriver {
    private AvalaraModule module;
    private XMLGregorianCalendar testDate;
    private String license;
    private String account;
    private String client;

    /**
     *
     */
    @Before
    public void setup() {
        GregorianCalendar gregory = new GregorianCalendar();
        gregory.setTime(new Date());

        try {
            testDate = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(
                            gregory);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        System.out.println("Avalara account" + System.getenv("avalaraAccount"));
        System.out.println("Avalara account" + System.getenv("avalaraLicense"));
        module = new AvalaraModule();
        module.setAddressServiceEndpoint("https://development.avalara.net/Tax/TaxSvc.asmx");
        module.setBatchServiceEndpoint("https://development.avalara.net/Batch/BatchSvc.asmx");
        AvalaraClient ac = new DefaultAvalaraClient();

        module.setClient(ac);
        account = System.getenv("avalaraAccount");
        license = System.getenv("avalaraLicense");
        client = "Mule";
        module.init();
    }

    @Test
    public void ping() {
        PingResult result = module.ping(account, license, client, "Hi");
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
        List<Map<String, Object>> addresses = new ArrayList<Map<String, Object>>() {
            {
                add(new HashMap<String, Object>() {
                    {
                        put("addressCode", "Origin");
                        put("line1", "Avalara");
                        put("line2", "900 Winslow Way");
                        put("line3", "Suite 100");
                        put("city", "Bainbridge Island");
                        put("region", "WA");
                        put("postalCode", "98110");
                        put("country", "USA");
                    }
                });
                add(new HashMap<String, Object>() {
                    {
                        put("addressCode", "Dest");
                        put("line1", "3130 Elliott");
                        put("city", "Seattle");
                        put("region", "WA");
                        put("postalCode", "98121");
                        put("country", "USA");
                    }
                });
            }
        };

        List<Map<String, Object>> lines = new ArrayList<Map<String, Object>>() {
            {
                add(new HashMap<String, Object>() {
                    {
                        put("no", "001");
                        put("itemCode", "ITEM CODE 1");
                        put("qty", 1);
                        put("amount", 4000);
                        put("discounted", false);
                        put("description", "item number 1");
                        put("taxIncluded", false);
                    }
                });
                add(new HashMap<String, Object>() {
                    {
                        put("no", "002");
                        put("itemCode", "ITEM CODE 1");
                        put("qty", 1);
                        put("amount", 1000);
                        put("discounted", false);
                        put("description", "item number 1");
                        put("taxIncluded", false);
                    }
                });
            }
        };

        return module.getTax(account, license, client, "TC", AvalaraDocumentType.SALES_INVOICE, docCode, testDate,
                null, "cusomer Code", null, "0", null, null, "Origin", "Dest", addresses,
                lines, DetailLevelType.DOCUMENT, null, "Test LocationCode", false, null,
                null, null, ServiceModeType.AUTOMATIC, testDate, "0", testDate);
    }

    private AdjustTaxResult adjustTax(String docCode) {
        List<Map<String, Object>> addresses = new ArrayList<Map<String, Object>>() {
            {
                add(new HashMap<String, Object>() {
                    {
                        put("addressCode", "Origin");
                        put("line1", "Avalara");
                        put("line2", "900 Winslow Way");
                        put("line3", "Suite 100");
                        put("city", "Bainbridge Island");
                        put("region", "WA");
                        put("postalCode", "98110");
                        put("country", "USA");
                    }
                });
                add(new HashMap<String, Object>() {
                    {
                        put("addressCode", "Dest");
                        put("line1", "3130 Elliott");
                        put("city", "Seattle");
                        put("region", "WA");
                        put("postalCode", "98121");
                        put("country", "USA");
                    }
                });
            }
        };

        List<Map<String, Object>> lines = new ArrayList<Map<String, Object>>() {
            {
                add(new HashMap<String, Object>() {
                    {
                        put("no", "001");
                        put("itemCode", "ITEM CODE 1");
                        put("qty", 1);
                        put("amount", 4000);
                        put("discounted", false);
                        put("description", "item number 1");
                        put("taxIncluded", false);
                    }
                });
                add(new HashMap<String, Object>() {
                    {
                        put("no", "002");
                        put("itemCode", "ITEM CODE 1");
                        put("qty", 1);
                        put("amount", 1000);
                        put("discounted", false);
                        put("description", "item number 1");
                        put("taxIncluded", false);
                    }
                });
            }
        };

        return module.adjustTax(account, license, client, 1, "some reason", "TC", AvalaraDocumentType.SALES_INVOICE, docCode, testDate,
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

        PostTaxResult postResult = module.postTax(account, license, client, null, "TC", AvalaraDocumentType.SALES_INVOICE,
                docCode, testDate, taxResult.getTotalAmount().toPlainString(),
                taxResult.getTotalTax().toPlainString(), false, docCode);

        assertEquals(SeverityLevel.SUCCESS, postResult.getResultCode());

        //Finally Cancel Tax and remove the entry from the system by calling new DocVoided
        CancelTaxResult cancelResult = module.cancelTax(account, license, client, null, "TC", AvalaraDocumentType.SALES_INVOICE, docCode, CancelCodeType.DOC_VOIDED);

        assertEquals(SeverityLevel.SUCCESS, cancelResult.getResultCode());
        // Check tax history

        GetTaxHistoryResult taxHistoryResult = module.getTaxHistory(account, license, client, null, "TC",
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
        cancelResult = module.cancelTax(account, license, client, null, "TC", AvalaraDocumentType.SALES_INVOICE,
                docCode, CancelCodeType.DOC_DELETED);

        assertEquals(SeverityLevel.SUCCESS, cancelResult.getResultCode());
    }

    @Test
    public void validateAValidAddress() throws Exception {


        ValidateResult response = module.validateAddress(account, license, client, "435 Ericksen Ave", null, null, null, "NE", null,
                "98110", null, 0, null, null, TextCaseType.DEFAULT, false, false, testDate);

        assertNotNull(response);
        assertEquals("Bainbridge Island", response.getValidAddresses().getValidAddress().get(0).getCity());
    }

    @Test
    public void validateAnInvalidAddress() throws Exception {
        ValidateResult response = module.validateAddress(account, license, client, "SARLAZA", null, null, null, null, null,
                null, null, 0, null, null, TextCaseType.DEFAULT, false, false, testDate);

        assertEquals(SeverityLevel.ERROR, response.getResultCode());
    }

    @Test
    public void saveBatchFile() throws Exception {
        String fileString = "ProcessCode,DocCode,DocType,DocDate,CompanyCode,CustomerCode,EntityUseCode,LineNo,TaxCode,TaxDate,ItemCode,Description,Qty,Amount,Discount,Ref1,Ref2,ExemptionNo,RevAcct,DestAddress,DestCity,DestRegion,DestPostalCode,DestCountry,OrigAddress,OrigCity,OrigRegion,OrigPostalCode,OrigCountry,LocationCode,SalesPersonCode,PurchaseOrderNo,CurrencyCode,ExchangeRate,ExchangeRateEffDate,PaymentDate,TaxIncluded,DestTaxRegion,OrigTaxRegion,Taxable,TaxType,TotalTax,CountryName,CountryCode,CountryRate,CountryTax,StateName,StateCode,StateRate,StateTax,CountyName,CountyCode,CountyRate,CountyTax,CityName,CityCode,CityRate,CityTax,Other1Name,Other1Code,Other1Rate,Other1Tax,Other2Name,Other2Code,Other2Rate,Other2Tax,Other3Name,Other3Code,Other3Rate,Other3Tax,Other4Name,Other4Code,Other4Rate,Other4Tax,ReferenceCode\n" +
                "3,INV00000137,3,2012-11-06,TC,A00000001,,2c92c0943aaaf3bf013add2b74db437a,,2012-11-06,Mule iON,,1,20,,2c92c0943aaaf3bf013add2b74db437a,2c92c0943aaaf3bf013add2b74c24378,,,30 Maiden Ln,San Francisco,California,94108-5429,United States,,,,,,,,,USD,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,";
        //OutputStream outputStream =   convertStringtoStream(fileString);

        System.out.print(fileString);

        BatchSaveResult saveResult = module.saveBatch("emiliano.lesende@mulesource.com", "muleftw1", client, BatchType.TRANSACTION_IMPORT, 156785, fileString, "filenr004");
        System.out.println(saveResult.getResultCode().value());
        //BatchFileSaveResult saveResult = module.saveBatchFile(account, license, client, 2, 2,"csv", "testbatch2", content);
        if (saveResult.getResultCode().value() != "Success") {
            for (Message message : saveResult.getMessages().getMessage()) {
                System.out.println(message.getRefersTo());
                System.out.println(message.getDetails());
                System.out.println(message.getSummary());
                System.out.println(message.getHelpLink());
                System.out.println(message.getSource());
            }

        } else {
            System.out.println("Batch Id = " + saveResult.getBatchId());
            System.out.println("Estimated Completion = " + saveResult.getEstimatedCompletion());

        }


    }

    @Test
    public void fetchBatch() throws Exception {


        //BatchFileFetchResult fetchResult = module.fetchBatchFile(account, license, client, "129829");

        Map<String, BatchFileFetchResult> fetchResult = module.fetchBatchFile(account, license, client, "129275");

        System.out.println("result size= " + fetchResult.get("result").getBatchFiles().getBatchFile().size());
        System.out.println(new String(fetchResult.get("result").getBatchFiles().getBatchFile().get(0).getContent()));


        if (fetchResult.get("error") != null) {
            System.out.println("result size= " + fetchResult.get("error").getBatchFiles().getBatchFile().size());
            System.out.println(new String(fetchResult.get("error").getBatchFiles().getBatchFile().get(0).getContent()));
        }


        //System.out.println("Batches = " + new String(fetchResult.getBatches().getBatch().get(0).getFiles().getBatchFile().get(0).getContent()));

    }

    @Test
    public void isBatchFinished() throws Exception {


        //BatchFileFetchResult fetchResult = module.fetchBatchFile(account, license, client, "129829");

        boolean isFinished = module.isBatchFinished(account, license, client, "129275");

        System.out.println("isFinished= " + isFinished);




        //System.out.println("Batches = " + new String(fetchResult.getBatches().getBatch().get(0).getFiles().getBatchFile().get(0).getContent()));

    }



    private static OutputStream convertStringtoStream(String string) {
        byte[] stringByte = string.getBytes();
        ByteArrayOutputStream bos = new ByteArrayOutputStream(string.length());

        try {
            bos.write(stringByte);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return bos;
    }


}
