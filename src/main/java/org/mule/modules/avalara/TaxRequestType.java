/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.avalara;


import com.avalara.avatax.services.AdjustTax;
import com.avalara.avatax.services.CancelTax;
import com.avalara.avatax.services.GetTax;
import com.avalara.avatax.services.PostTax;
import com.avalara.avatax.services.CommitTax;
import com.avalara.avatax.services.GetTaxHistory;
import org.apache.commons.lang.StringUtils;


/**
 * @author Gaston Ponti
 * @since Oct 18, 2011
 */

public enum TaxRequestType
{
    /**
     * GetTax is the core of the Avalara Service. It is capable of collecting a 
     * string of elements contained in a single object contained in a transaction
     * document (invoice, quote, sales order, etc.) including the origin (shipped 
     * from address), destination (shipped to address), and line item (products, 
     * Freight, Service, etc.) information.
     * The return of a successful GetTax call is at a minimum Total Amount and 
     * Total Tax. By setting the DetailLevel property - for example - from "Tax" 
     * to "Line" a much greater set of results will be returned.
     */
    GetTax(GetTax.class),

    /**
     * PostTax can be used to set the document status to several states during 
     * a SalesInvoice process (SalesOrder processes are not saved). Invoices appear 
     * initially as "uncommitted" on the Admin Console and do not appear at all 
     * on Avalara reporting until they are committed.
     * A posted document can be changed (overwritten not amended) with subsequent 
     * GetTax calls to the same DocCode (Document Number).
     * The typical integration point for PostTax/CommitTax process is when it is 
     * required by the ERP or a business process requires that an invoice is posted 
     * indicating that it has been reviewed by a second level of management, the 
     * "committed" indicating that it has been certified to be ready for tax reporting.
     */
    PostTax(PostTax.class),
    
    /**
     * CommitTax can be used to set the document status to several states during 
     * a SalesInvoice process (SalesOrder processes are not saved). Invoices appear 
     * initially as "uncommitted" on the Admin Console and do not appear at all 
     * on Avalara reporting until they are committed.
     * CommitTax completes the two stage process and sets the Document Status to 
     * Committed on mm/dd/yyyy however it cannot be overwritten as the PostTax 
     * operation was.
     */
    CommitTax(CommitTax.class),
    
    /**
     * GetTaxHistory provides a means to report or retrieve data on historical 
     * invoices (or Document ID's).
     * GetTaxHistory provides a mechanism to write custom reports.
     * <p>
     * GetTaxHistory returns both the original GetTaxRequest object, as well as 
     * the GetTaxResult object. The GetTaxResult object shows the current state 
     * of the invoice in the Avalara system.
     */
    GetTaxHistory(GetTaxHistory.class),
    
    /**
     * CancelTax provides a mechanism to recover from posting problems, or completely 
     * remove an invoice from tax reporting. The effect of CancelTax depends upon 
     * the current state of an invoice (uncommitted, saved, or committed).
     * <p>
     * An invoice with a state of saved is one which has not been posted or committed 
     * (last operation = GetTax). Calling CancelTax on such an invoice has no effect.
     * <p>
     * An invoice with a state of committed is one which has been committed (and 
     * appears in Sales Tax Reporting). Calling CancelTax on a committed invoice has 
     * the effect of removing it from reporting, but moves it to a fourth state Voided.
     * <p>
     * A Voided invoice cannot have its status changed (and the invoice number cannot
     * be re-used).
     */
    CancelTax(CancelTax.class),
    /**
     * AdjustTax provides a mechanism to adjust tax.
     */

    AdjustTax(AdjustTax.class);




    private final Class<?> type;
    
    private TaxRequestType(Class<?> type)
    {
        this.type = type;
    }
    
    @SuppressWarnings("unchecked")
    public <T> T newInstance()
    {
        try
        {
            return (T) type.newInstance();
        }
        catch (Exception e)
        {
            throw new AssertionError(e);
        }
    }

    /**
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> Class<T> getType()
    {
        return (Class<T>) type;
    }
    
    /**
     * @return the simple name of the associated class for this entity type
     */
    public String getSimpleName()
    {
        return getType().getSimpleName();
    }
    
    public String getResourceName()
    {
        return StringUtils.uncapitalize(getSimpleName());
    }
}
