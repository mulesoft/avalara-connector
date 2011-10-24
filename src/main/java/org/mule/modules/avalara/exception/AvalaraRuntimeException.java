/**
 * Mule Avalara Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
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

    /**
     * Creates the AvalaraRuntimeException.
     * 
     * @param message
     */

    public AvalaraRuntimeException(String message)
    {
        super(message);
    }
}
