/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.avalara.api;

import org.mule.modules.avalara.TaxRequestType;

import com.avalara.avatax.services.BaseResult;
import com.avalara.avatax.services.PingResult;
import com.avalara.avatax.services.ValidateRequest;
import com.avalara.avatax.services.ValidateResult;

/**
 * @author Gaston Ponti
 * @since Oct 17, 2011
 */
public interface AvalaraClient
{
    <T extends BaseResult> T sendToAvalara(String account, String licence, String client, TaxRequestType requestType, Object obj);
    
    ValidateResult validateAddress(String account, String licence, String client, ValidateRequest validateRequest);

    PingResult ping(String account, String licence, String client, String message);
}
