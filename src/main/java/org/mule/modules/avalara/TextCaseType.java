/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.avalara;

import com.avalara.avatax.services.TextCase;


/**
 * The casing to apply to the valid address(es) returned in the validation result.
 * @author Gaston Ponti
 * @since Oct 25, 2011
 */

public enum TextCaseType
{
    /**
     * Default casing for the account.
     */
    DEFAULT("Default"),
    
    /**
     *  Upper case.
     */
    UPPER("Upper"),
    
    /**
     * Mixed case.
     */
    MIXED("Mixed");
    
    private final String value;

    TextCaseType(String value) 
    {
        this.value = value;
    }

    public String value() 
    {
        return value;
    }
    
    public TextCase toAvalaraTextCase()
    {
        return TextCase.fromValue(value);
    }
}
