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

import com.avalara.avatax.services.DocumentType;

/**
 * @author Gaston Ponti
 * @since Oct 18, 2011
 */

public enum AvalaraDocumentType
{
    /**
     * 
     */
    SALES_ORDER("SalesOrder"),
    /**
     * 
     */
    SALES_INVOICE("SalesInvoice"),
    /**
     * 
     */
    PURCHASE_ORDER("PurchaseOrder"),
    /**
     * 
     */
    PURCHASE_INVOICE("PurchaseInvoice"),
    /**
     * 
     */
    RETURN_ORDER("ReturnOrder"),
    /**
     * 
     */
    RETURN_INVOICE("ReturnInvoice");
    
    private final String value;

    AvalaraDocumentType(String value)
    {
        this.value = value;
    }

    public DocumentType toDocumentType()
    {
        return DocumentType.fromValue(value);
    }
}
