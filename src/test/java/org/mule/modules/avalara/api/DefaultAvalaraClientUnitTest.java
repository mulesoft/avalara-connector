/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.avalara.api;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import com.avalara.avatax.services.AddressSvcSoap;
import com.avalara.avatax.services.BatchSvcSoap;
import com.avalara.avatax.services.TaxSvcSoap;

public class DefaultAvalaraClientUnitTest {

   private DefaultAvalaraClient client = new DefaultAvalaraClient("", "", "");

   @Test
   public void taxServiceShouldBeCached() {
      TaxSvcSoap taxService = client.getTaxService();
      assertNotNull(taxService);
      assertSame(taxService, client.getTaxService());
   }

   @Test
   public void addressServiceShouldBeCached() {
      AddressSvcSoap addressService = client.getAddressService();
      assertNotNull(addressService);
      assertSame(addressService, client.getAddressService());
   }

   @Test
   public void batchServiceShouldBeCached() {
      BatchSvcSoap batchService = client.getBatchService();
      assertNotNull(batchService);
      assertSame(batchService, client.getBatchService());
   }
}
