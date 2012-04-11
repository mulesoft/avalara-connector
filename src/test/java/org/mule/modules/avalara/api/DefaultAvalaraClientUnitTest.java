/**
 * Mule Avalara Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.avalara.api;

import static org.junit.Assert.*;

import org.junit.Test;

import com.avalara.avatax.services.AddressSvcSoap;
import com.avalara.avatax.services.TaxSvcSoap;

public class DefaultAvalaraClientUnitTest 
{

    private DefaultAvalaraClient client = new DefaultAvalaraClient();

   @Test
   public void taxSvcGetsCached() 
   {
      TaxSvcSoap taxService = client.getTaxService();
      assertNotNull(taxService);
      assertSame(taxService, client.getTaxService());
   }

   @Test
   public void addressSvcGetsCached() 
   {
      AddressSvcSoap addressService = client.getAddressService();
      assertNotNull(addressService);
      assertSame(addressService, client.getAddressService());
   }

}
