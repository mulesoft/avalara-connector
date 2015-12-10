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
    protected static String makeAvalaraMessage(ArrayOfMessage messages)
    {
        String message = "";
        
        if(messages != null){
        	for (Message msj : messages.getMessage())
        	{
        		message += msj.getName() +
        				": (" + msj.getRefersTo() + ") " +  msj.getSummary() + "\n";
        	}
        }
        
        return message;
    }
}
