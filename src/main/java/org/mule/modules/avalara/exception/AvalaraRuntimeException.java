/*
 * Copyright (c) 2011 Zauber S.A.  -- All rights reserved
 */

package org.mule.modules.avalara.exception;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.avalara.avatax.services.ArrayOfMessage;

/**
 * @author Gaston Ponti
 * @since Oct 18, 2011
 */

public class AvalaraRuntimeException extends RuntimeException
{

    
    /**
     * Creates the AvalaraRuntimeException.
     *
     * @param messages
     */
    
    public AvalaraRuntimeException(ArrayOfMessage messages)
    {
        super(ToStringBuilder.reflectionToString(messages));
    }
}
