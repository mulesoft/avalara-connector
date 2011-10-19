/*
 * Copyright (c) 2011 Zauber S.A.  -- All rights reserved
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

