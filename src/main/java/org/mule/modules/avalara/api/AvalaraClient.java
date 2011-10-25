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

import org.mule.modules.avalara.RequestType;

import com.avalara.avatax.services.BaseResult;
import com.avalara.avatax.services.GetTaxRequest;
import com.avalara.avatax.services.GetTaxResult;
import com.avalara.avatax.services.PingResult;

/**
 * @author Gaston Ponti
 * @since Oct 17, 2011
 */
public interface AvalaraClient
{
    <T extends BaseResult> T sendToAvalara(RequestType requestType, Object obj);

    GetTaxResult getTax(GetTaxRequest getTaxRequest);

    PingResult ping(String message);
}
