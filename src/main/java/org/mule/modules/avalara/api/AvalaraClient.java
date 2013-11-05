/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
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
    
    BatchFetchResult fetchBatch(FetchRequest fetchRequest);

    BatchFileFetchResult fetchBatchFile(FetchRequest fetchRequest);

    BatchSaveResult saveBatch(Batch batch);

    PingResult ping(String message);

    String getConnectionIdentifier();
}
