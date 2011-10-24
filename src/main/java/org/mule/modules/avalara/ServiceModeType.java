/*
 * Copyright (c) 2011 Zauber S.A.  -- All rights reserved
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
