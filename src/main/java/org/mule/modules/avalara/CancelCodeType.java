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
 * Specifies the reason the tax calculation is being canceled (or in the case of 
 * posting, returned to its prior state).
 * @author Gaston Ponti
 * @since Oct 18, 2011
 */

public enum CancelCodeType
{
    /**
     *  Unspecified reason
     */
    UNSPECIFIED("Unspecified"),
    
    /**
     * Specifies the post operation failed when attempting to post an invoice within
     * a client's application, for example, to the client's General Ledger; The
     * document's status will be changed to <b>Saved</b>.
     */
    POST_FAILED("PostFailed"),
    
    /**
     * Specifies the document was deleted within the client's application and
     * should be removed from the AvaTax records; If the document within AvaTax
     * is already committed, the document status will be changed to <b>Cancelled</b>
     * and retained for historical records;  If the document was not committed,
     * (was <b>Saved</b> or <b>Posted</b>) the document will be deleted within AvaTax.
     */
    DOC_DELETED("DocDeleted"),
    
    /**
     * Specifies the document was voided within the client's application and
     * should be removed from the AvaTax records; If the document within AvaTax
     * is already committed, the document status will be changed to <b>Cancelled</b>
     * and retained for historical records;  If the document was not committed,
     * (was <b>Saved</b> or <b>Posted</b>) the document will be deleted within AvaTax.
     */
    DOC_VOIDED("DocVoided"),

    /**
     * Specifies the document was adjusted within the client's application and
     * should be removed from the AvaTax records; If the document within AvaTax
     * is already committed, the document status will be changed to <b>Cancelled</b>
     * and retained for historical records;  If the document was not committed,
     * (was <b>Saved</b> or <b>Posted</b>) the document will be deleted within AvaTax.
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

