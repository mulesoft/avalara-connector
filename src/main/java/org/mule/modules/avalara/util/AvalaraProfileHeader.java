/**
 * Mule Avalara Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.avalara.util;

import java.util.List;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 * @author Gaston Ponti
 * @since Oct 25, 2011
 */

public class AvalaraProfileHeader implements SOAPHandler<SOAPMessageContext>
{

    public static final String PROFILE_ELEMENT = "Profile";
    public static final String NAMESPACE = "http://avatax.avalara.com/services";
    public static final String AVALARA_PREFIX = "aval";
    
//    /** Namespace for the SOAP Envelope. */
//    private static String SOAPENVNamespace = "http://schemas.xmlsoap.org/soap/envelope/";
//
//    /** The prefix that will be used for the SOAP Envelope namespace. */
//    private static String SOAPENVPrefix = "soapenv";
//
//    /** Namespace for the WS-Security SOAP header elements. */
//    private static String WSSENamespace = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
//
//    /** The prefix that will be used for the WS-Security namespace. */
//    private static String WSSEPrefix = "wsse";
//
//    /**
//     * The WS-Security URI that specifies that the password will be transmitted as
//     * plain text.
//     */
//    private static String WSSEPasswordText = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText";

    /**
     */
    private String client;

    /**
     * This method created an instance of the AvalaraProfileHeader class and adds it as
     * a handler to the bindingProvider supplied.
     * 
     * @param bindingProvider The client stub to which the handler will be added. The
     *            most convenient way to obtain the required bindingProvvider is to
     *            call one of the getPort methods on the Service class for the Web
     *            service and then cast the returned object to a BindingProvider.
     * @param client The client for the system user.
     */
    @SuppressWarnings("unchecked")
    public static void sign(BindingProvider bindingProvider, String client)
    {
        List<Handler> handlerChain = bindingProvider.getBinding().getHandlerChain();
        handlerChain.add(new AvalaraProfileHeader(client));
        bindingProvider.getBinding().setHandlerChain(handlerChain);
    }

    /**
     * Creates a SOAPSimpleCredentials handler and initialises the member variables. In
     * most cases, the sign static method should be used instead.
     * 
     * @param client The client for the system user.
     */
    public AvalaraProfileHeader(String client)
    {
        this.client = client;
    }

    /**
     * Returns null as this handler doesn't process any Headers, it just adds one.
     */
    public Set<QName> getHeaders()
    {
        return null;
    }

    /**
     * Adds WS-Security header to request messages.
     */
    public boolean handleMessage(SOAPMessageContext smc)
    {
        Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (outboundProperty.booleanValue())
        {
            addProfileHeader(smc, client);
        }
        return true;
    }

    /**
     * Returns true, no action is taken for faults messages.
     */
    public boolean handleFault(SOAPMessageContext smc)
    {
        return true;
    }

    public void close(MessageContext messageContext)
    {
    }

    /**
     * Adds a Profile header containing a client to a SOAP message.
     * 
     * @param smc The AvalaraProfileHeader to which the Profile header will be
     *            added.
     * @param client The Profile client.
     * @throws java.lang.RuntimeException This exception will be thrown if a
     *             SOAPException occurs when modifying the message.
     */
    private void addProfileHeader(SOAPMessageContext smc, String client)
    {

        try
        {
            // Get the SOAP Header
            SOAPMessage message = smc.getMessage();
            SOAPHeader header = message.getSOAPHeader();
            if (header == null)
            {
                // Create header as it doesn't already exist
                message.getSOAPPart().getEnvelope().addHeader();
                header = message.getSOAPHeader();
            }

            SOAPElement headerProfile = header.addChildElement(PROFILE_ELEMENT, AVALARA_PREFIX, NAMESPACE);
//            headerProfile.addAttribute(message.getSOAPPart().getEnvelope().createName("mustUnderstand",
//                SOAPENVPrefix, SOAPENVNamespace), "1");
  
            headerProfile.addChildElement("Client", AVALARA_PREFIX, NAMESPACE).addTextNode(client);
            
        }
        catch (SOAPException e)
        {
            throw new RuntimeException("Failed to add Profile header to request", e);
        }
    }
}
