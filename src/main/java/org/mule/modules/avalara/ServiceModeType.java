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
 * Specifies the type of tax override.
 * This is only supported by AvaLocal servers. It provides the ability to controls whether tax is calculated locally or remotely when using an AvaLocal server.
 * The default is Automatic which calculates locally unless remote is necessary for non-local addresses
 * @author Gaston Ponti
 * @since Oct 19, 2011
 */
public enum ServiceModeType
{
    /**
     * Automated handling by local and/or remote server.
     */
    AUTOMATIC("Automatic"),

    /**
     * AvaLocal server only. Lines requiring remote will not be calculated.
     */
    LOCAL("Local"),

    /**
     * All lines are calculated by AvaTax remote server.
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
