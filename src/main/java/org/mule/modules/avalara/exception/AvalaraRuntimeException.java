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
public class AvalaraRuntimeException extends RuntimeException
{

    /**
     * Creates the AvalaraRuntimeException.
     * 
     * @param messages
     */
    public AvalaraRuntimeException(ArrayOfMessage messages)
    {
        super(makeAvalaraMessage(messages));
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
    
    /**
     * @param messages
     * @return
     */
    private static String makeAvalaraMessage(ArrayOfMessage messages)
    {
        String message = "";
        for (Message msj : messages.getMessage())
        {
            message += msj.getName() +
                ": (" + msj.getRefersTo() + ") " +  msj.getSummary() + "\n";
        }
        
        return message;
    }
}
