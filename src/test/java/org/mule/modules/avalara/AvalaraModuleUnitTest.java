/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.avalara;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mule.modules.avalara.api.AvalaraClient;

public class AvalaraModuleUnitTest
{
    private AvalaraModule module;
    private AvalaraClient clientMock;

    @Before
    public void setUp() {
        clientMock = mock(AvalaraClient.class);
        module = new AvalaraModule();
        module.setClient(clientMock);
    }

    @Test
    public void testPing() {
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

}
