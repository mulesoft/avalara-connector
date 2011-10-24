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

import com.avalara.avatax.services.DetailLevel;

/**
 * In a GetTaxRequest (or GetTaxHistoryRequest) the DetailLevel specifies the level 
 * of tax detail to return to the client application following a tax calculation.
 * 
 * @author Gaston Ponti
 * @since Oct 18, 2011
 */
public enum DetailLevelType
{
    /**
     * Document (GetTaxResult) level details; TaxLines will not be returned.
     */
    DOCUMENT("Document"),
    
    /**
     * Reserved for future use.
     */
    SUMMARY("Summary"),
    
    /**
     * Line level details (includes Document details). TaxLines will be returned 
     * but TaxDetails will not be returned.
     */
    LINE("Line"),
    
    /**
     * Tax jurisdiction level details (includes Document, TaxLines, and TaxDetails)
     */
    TAX("Tax"),
    
    /**
     * In addition to Tax level details, indicates that the server should return 
     * information about how the tax was calculated. Intended for use only while 
     * the SDK is in a development environment.
     */
    DIAGNOSTIC("Diagnostic");
    
    private final String value;

    DetailLevelType(String value) 
    {
        this.value = value;
    }

    public String value() 
    {
        return value;
    }
    
    public DetailLevel toAvalaraDetailLevel()
    {
        return DetailLevel.fromValue(value);
    }
}
