/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.modules.avalara.api;

import com.avalara.avatax.services.*;

import org.mule.modules.avalara.AddressRequestType;
import org.mule.modules.avalara.BatchRequestType;
import org.mule.modules.avalara.TaxRequestType;

/**
 * @author Gaston Ponti
 * @since Oct 17, 2011
 */
public interface AvalaraClient {
    public <T extends BaseResult> T sendTaxRequestToAvalara(TaxRequestType entityType, Object obj);
    
    public <T extends BaseResult> T sendAddressRequestToAvalara(AddressRequestType entityType, Object obj);
    
    public <T extends BaseResult> T sendBatchRequestToAvalara(BatchRequestType entityType, Object obj);
    
    String getConnectionIdentifier();
}
