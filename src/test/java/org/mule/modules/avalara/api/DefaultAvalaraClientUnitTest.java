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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.avalara.avatax.services.AddressSvcSoap;
import com.avalara.avatax.services.TaxSvcSoap;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.junit.Test;

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
   
   @Test
   public void notIsolationTest() throws Exception
   {
       ExecutorService threadsPool = Executors.newFixedThreadPool(2);
       final DefaultAvalaraClient client2 = spy(new DefaultAvalaraClient());
       TaxSvcSoap soapService = mock(TaxSvcSoap.class);
       when(client2.getTaxService()).thenReturn(soapService);
       
       final CountDownLatch countDown = new CountDownLatch(2);
       final Semaphore availableFirstThread = new Semaphore(1);
       final Semaphore availableSecondThread = new Semaphore(1);
       availableFirstThread.acquire();
       availableSecondThread.acquire();

       threadsPool.execute(new Runnable()
       {
           @Override
           public void run()
           {
               try
               {
                    Assert.assertNull(client2.getClient());
                    Assert.assertNull(client2.getUsername());
                    Assert.assertNull(client2.getPassword());
                    client2.ping("accountThread1", "licenseThread1", "clientThread1", "a message");
                    availableSecondThread.release();
                    availableFirstThread.acquire();
                    Assert.assertEquals("accountThread1", client2.getUsername());
                    Assert.assertEquals("licenseThread1", client2.getPassword());
                    Assert.assertEquals("clientThread1", client2.getClient());
                    availableSecondThread.release();
                    countDown.countDown();
               }
               catch (Exception e)
               {
                   e.printStackTrace();
               }
           }
       });
       
       threadsPool.execute(new Runnable()
       {
           @Override
           public void run()
           {
               try
               {
                   availableSecondThread.acquire();
                   Assert.assertNull(client2.getClient());
                   Assert.assertNull(client2.getUsername());
                   Assert.assertNull(client2.getPassword());
                   client2.ping("accountThread2", "licenseThread2", "clientThread2", "a message");
                   availableFirstThread.release();
                   availableSecondThread.acquire();
                   Assert.assertEquals("accountThread2", client2.getUsername());
                   Assert.assertEquals("licenseThread2", client2.getPassword());
                   Assert.assertEquals("clientThread2", client2.getClient());
                   countDown.countDown();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
           }
       });

       if (!countDown.await(30, TimeUnit.SECONDS))
       {
           Assert.fail("Incomplete tasks");
       }
       
       Assert.assertNull(client2.getClient());
       Assert.assertNull(client2.getUsername());
       Assert.assertNull(client2.getPassword());
       
   }
   
}
