/**
 * Mule Avalara Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.avalara;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mule.modules.avalara.api.AvalaraClient;

import com.avalara.avatax.services.CancelCode;
import com.avalara.avatax.services.CancelTaxRequest;
import com.avalara.avatax.services.CommitTaxRequest;
import com.avalara.avatax.services.DetailLevel;
import com.avalara.avatax.services.DocumentType;
import com.avalara.avatax.services.GetTaxHistoryRequest;

public class AvalaraModuleUnitTest
{
    private AvalaraModule module;
    private AvalaraClient clientMock;

    @Before
    public void setUp()
    {
        clientMock = mock(AvalaraClient.class);

        module = new AvalaraModule();
        module.setClient(clientMock);
        module.init();
    }

    @Test
    public void testPing()
    {
        module.ping("hello world");
        
        verify(clientMock).ping(eq("hello world"));
    }

//    @Test
//    public void testGetTax()
//    {
//        module.getTax(companyCode, docType, docCode, docDate, salespersonCode, customerCode,
//            customerUsageType, discount, purchaseOrderNo, exemptionNo, originCode, destinationCode,
//            baseAddresses, lines, detailLevel, referenceCode, locationCode, commit, batchCode, taxOverride,
//            currencyCode, serviceMode, paymentDate, exchangeRate, exchangeRateEffDate);
//    }
//
//    @Test
//    public void testPostTax()
//    {
//        module.postTax(docId, companyCode, docType, docCode, docDate, totalAmount, totalTax, commit, newDocCode);
//    }

    @Test
    public void testCommitTax()
    {
        module.commitTax("123", "Mule", AvalaraDocumentType.PURCHASE_INVOICE, "OldCode", "NewCode");
        CommitTaxRequest commitTaxRequest = new CommitTaxRequest() { {
            docId = "123";
            companyCode  = "Mule";
            docType = DocumentType.PURCHASE_INVOICE;
            docCode = "OldCode";
            newDocCode = "NewCode";
        } };
        verify(clientMock).sendToAvalara(eq(TaxRequestType.CommitTax), refEq(commitTaxRequest));
        
    }

    @Test
    public void testGetTaxHistory()
    {
        module.getTaxHistory(null, "Mule", AvalaraDocumentType.PURCHASE_ORDER, null,
            DetailLevelType.DIAGNOSTIC);
        
        GetTaxHistoryRequest getTaxRequest = new GetTaxHistoryRequest() { {
            companyCode = "Mule";
            detailLevel = DetailLevel.DIAGNOSTIC;
            docType = DocumentType.PURCHASE_ORDER;
        } };
        verify(clientMock).sendToAvalara(eq(TaxRequestType.GetTaxHistory), refEq(getTaxRequest));
    }

    @Test
    public void testCancelTax()
    {
        module.cancelTax(null, "Mule", AvalaraDocumentType.PURCHASE_ORDER, null,
            CancelCodeType.DOC_DELETED);
        
        CancelTaxRequest cancelTaxRequest = new CancelTaxRequest() { {
            companyCode = "Mule";
            cancelCode = CancelCode.DOC_DELETED;
            docType = DocumentType.PURCHASE_ORDER;
        } };
        verify(clientMock).sendToAvalara(eq(TaxRequestType.CancelTax), refEq(cancelTaxRequest));
    }

}
