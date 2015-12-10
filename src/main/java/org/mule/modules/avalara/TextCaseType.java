/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
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
