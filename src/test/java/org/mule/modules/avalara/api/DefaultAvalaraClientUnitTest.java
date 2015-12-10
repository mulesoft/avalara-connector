/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.modules.avalara.api;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import com.avalara.avatax.services.AddressSvcSoap;
import com.avalara.avatax.services.BatchSvcSoap;
import com.avalara.avatax.services.TaxSvcSoap;

public class DefaultAvalaraClientUnitTest {

   private DefaultAvalaraClient client = new DefaultAvalaraClient("some_account", "some_client", "some_license");

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
