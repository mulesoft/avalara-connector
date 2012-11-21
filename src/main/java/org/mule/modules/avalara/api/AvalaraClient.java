/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.avalara.api;

import com.avalara.avatax.services.*;
import org.mule.modules.avalara.TaxRequestType;

/**
 * @author Gaston Ponti
 * @since Oct 17, 2011
 */
public interface AvalaraClient {
    <T extends BaseResult> T sendToAvalara(String account, String licence, String client, TaxRequestType requestType, Object obj);

    ValidateResult validateAddress(String account, String licence, String client, ValidateRequest validateRequest);

    BatchFetchResult fetchBatch(String account, String licence, String client, FetchRequest fetchRequest);

    BatchFileFetchResult fetchBatchFile(String account, String licence, String client, FetchRequest fetchRequest);

    BatchSaveResult saveBatch(String account, String licence, String client, Batch batch);

    PingResult ping(String account, String licence, String client, String message);
}
