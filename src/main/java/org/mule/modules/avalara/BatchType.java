/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.modules.avalara;

/**
 * The document type specifies the category of the document and affects how the document
 * is treated after a tax calculation. Specified when constructing a {@link com.avalara.avatax.services.GetTaxRequest}.
 * @author Albin Kjellin
 * @since Nov 09, 2012
 */

public enum BatchType
{
    /**
     *  Invoices, returns and credit memos.
     */
    TRANSACTION_IMPORT("TransactionImport"),

    /**
     *  The products and services (SKUs) you sell, and the charges (freight, handling, and other miscellaneous charges) used by your business.
     */
    ITEM_IMPORT("ItemImport"),

    /**
     *  ECMS Exemption Certificate entries that hold important data accurately representing an Exemption Certificate.
     */
    EXEMPTION_CERTIFICATE_IMPORT("ExcemptionCertificateImport"),

    /**
     *  Descriptive and address information for physical locations of Company buildings and sales people.
     */
    COMPANY_LOCACTION_IMPORT("CompanyLocationImport"),


    /**
     *  Rules used to override the default taxing behavior of AvaTax Calc when tax laws for a particular jurisdiction require special handling.
     */
    TAX_RULE_IMPORT("TaxRuleImport"),

    /**
     *  Reserved for future use.
     */
    DOCUMENT_IMPORT("DocumentImport");

    private final String value;

    BatchType(String value)
    {
        this.value = value;
    }

    public BatchType toBatchType(String batchType)
    {
        for (BatchType b: BatchType.values()) {
            if (b.value.equals(batchType)) {
                return b;
            }
        }
        throw new IllegalArgumentException(batchType);
    }

    public String value() {
        return value;
    }

}
