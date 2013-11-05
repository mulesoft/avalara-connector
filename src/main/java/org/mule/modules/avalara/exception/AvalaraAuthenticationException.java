/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
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
