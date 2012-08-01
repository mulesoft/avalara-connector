/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.avalara;

import com.avalara.avatax.services.DocStatus;
import com.avalara.avatax.services.DocumentType;
import com.avalara.avatax.services.GetTaxRequest;
import com.avalara.avatax.services.GetTaxResult;

/**
 * The document type specifies the category of the document and affects how the document
 * is treated after a tax calculation. Specified when constructing a {@link GetTaxRequest}.
 * @author Gaston Ponti
 * @since Oct 18, 2011
 */

public enum AvalaraDocumentType
{
    /**
     *  Sales Order, estimate or quote. This is a temporary document type and is not saved in tax history.
     * {@link GetTaxResult} will return with a {@link DocStatus} of <b>Temporary</b>.
     */
    SALES_ORDER("SalesOrder"),
 
    /**
     *  The document is a permanent invoice; document and tax calculation results are saved in the tax history.
     * {@link GetTaxResult} will return with a {@link DocStatus} of <b>Saved</b>
     */
    SALES_INVOICE("SalesInvoice"),

    /**
     * Purchase order, estimate, or quote. This is a temporary document type and is not saved in tax history.
     * {@link GetTaxResult} will return with a {@link DocStatus} of <b>Temporary</b>.
     */
    PURCHASE_ORDER("PurchaseOrder"),

    /**
     *  The document is a permanent invoice; document and tax calculation results are saved in the tax history.
     * {@link GetTaxResult} will return with a {@link DocStatus} of <b>Saved</b>.
     */
    PURCHASE_INVOICE("PurchaseInvoice"),

    /**
     * Sales Return Order. This is a temporary document type and is not saved in tax history.
     * {@link GetTaxResult} will return with a {@link DocStatus} of <b>Temporary</b>.
     */
    RETURN_ORDER("ReturnOrder"),

    /**
     *  The document is a permanent sales return invoice; document and tax calculation results are
     * saved in the tax history {@link GetTaxResult} will return with a {@link DocStatus}
     * of <b>Saved</b>.
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
