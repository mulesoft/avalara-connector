/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.modules.avalara.exception;

import com.avalara.avatax.services.ArrayOfMessage;
import com.avalara.avatax.services.Message;

/**
 * @author Gaston Ponti
 * @since Oct 18, 2011
 */
public class AvalaraAuthenticationException extends AvalaraRuntimeException
{

    /**
     * Creates the AvalaraAuthenticationException.
     * 
     * @param messages
     */
    public AvalaraAuthenticationException(ArrayOfMessage messages)
    {
        super(makeAvalaraMessage(messages));
    }

    /**
     * Creates the AvalaraAuthenticationException.
     * 
     * @param message
     */
    public AvalaraAuthenticationException(String message)
    {
        super(message);
    }
}
