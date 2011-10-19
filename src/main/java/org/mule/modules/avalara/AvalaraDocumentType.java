/*
 * Copyright (c) 2011 Zauber S.A.  -- All rights reserved
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
