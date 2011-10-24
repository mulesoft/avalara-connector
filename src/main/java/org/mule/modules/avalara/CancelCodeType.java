/**
 * Mule Avalara Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.avalara;

import com.avalara.avatax.services.CancelCode;

/**
 * @author Gaston Ponti
 * @since Oct 18, 2011
 */

public enum CancelCodeType
{
    /**
     * 
     */
    UNSPECIFIED("Unspecified"),
    
    /**
     * 
     */
    POST_FAILED("PostFailed"),
    
    /**
     * 
     */
    DOC_DELETED("DocDeleted"),
    
    /**
     * 
     */
    DOC_VOIDED("DocVoided"),
    /**
     * 
     */
    ADJUSTMENT_CANCELLED("AdjustmentCancelled");
    
    private final String value;

    CancelCodeType(String value) 
    {
        this.value = value;
    }

    public String value() 
    {
        return value;
    }
    
    public CancelCode toAvalaraCancelCode()
    {
        return CancelCode.fromValue(value);
    }
}

