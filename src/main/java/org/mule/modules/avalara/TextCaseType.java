/*
 * Copyright (c) 2011 Zauber S.A.  -- All rights reserved
 */
	
package org.mule.modules.avalara;

import com.avalara.avatax.services.TextCase;


/**
 * @author Gaston Ponti
 * @since Oct 25, 2011
 */

public enum TextCaseType
{
    /**
     * 
     */
    DEFAULT("Default"),
    
    /**
     * 
     */
    UPPER("Upper"),
    
    /**
     * 
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
