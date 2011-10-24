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

import com.avalara.avatax.services.ServiceMode;


/**
 * @author Gaston Ponti
 * @since Oct 19, 2011
 */
public enum ServiceModeType
{
    /**
     * 
     */
    AUTOMATIC("Automatic"),

    /**
     * 
     */
    LOCAL("Local"),

    /**
     * 
     */
    REMOTE("Remote");
    
    private final String value;

    ServiceModeType(String value)
    {
        this.value = value;
    }

    public ServiceMode toAvalaraServiceMode()
    {
        return ServiceMode.fromValue(value);
    }
}
