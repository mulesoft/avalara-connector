/*
 * Copyright (c) 2011 Zauber S.A.  -- All rights reserved
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
 * @since Oct 20, 2011
 */
public class SOAPSimpleCredentials implements SOAPHandler<SOAPMessageContext>
{

    /** Namespace for the SOAP Envelope. */
    private static String SOAPENVNamespace = "http://schemas.xmlsoap.org/soap/envelope/";

    /** The prefix that will be used for the SOAP Envelope namespace. */
    private static String SOAPENVPrefix = "soapenv";

    /** Namespace for the WS-Security SOAP header elements. */
    private static String WSSENamespace = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";

    /** The prefix that will be used for the WS-Security namespace. */
    private static String WSSEPrefix = "wsse";

    /**
     * The WS-Security URI that specifies that the password will be transmitted as
     * plain text.
     */
    private static String WSSEPasswordText = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText";

    /**
     * The user name that will be sent in the WS-Security header on the SOAP request
     * message. This is of the form systemid@tenant.
     */
    private String username;

    /**
     * The password that will be sent in the WS-Security header on the SOAP request
     * message.
     */
    private String password;

    /**
     * This method created an instance of the SOAPSimpleCredentials class and adds it as
     * a handler to the bindingProvider supplied.
     * 
     * @param bindingProvider The client stub to which the handler will be added. The
     *            most convenient way to obtain the required bindingProvvider is to
     *            call one of the getPort methods on the Service class for the Web
     *            service and then cast the returned object to a BindingProvider.
     * @param username The id and tenant name for the user. This is of the form
     *            systemid@tenant.
     * @param password The password for the system user.
     */
    @SuppressWarnings("unchecked")
    public static void addSOAPSimpleCredentials(BindingProvider bindingProvider, String username, String password)
    {
        List<Handler> handlerChain = bindingProvider.getBinding().getHandlerChain();
        handlerChain.add(new SOAPSimpleCredentials(username, password));
        bindingProvider.getBinding().setHandlerChain(handlerChain);
    }

    /**
     * Creates a SOAPSimpleCredentials handler and initialises the member variables. In
     * most cases, the addSOAPSimpleCredentials static method should be used instead.
     * 
     * @param username The id and tenant name for the user. This is of the form
     *            systemid@tenant.
     * @param password The password for the system user.
     */
    public SOAPSimpleCredentials(String username, String password)
    {
        this.username = username;
        this.password = password;
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
            addWSSecurityHeader(smc, username, password);
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
     * Adds a WS-Security header containing a UsernameToken to a SOAP message.
     * 
     * @param smc The SOAPMessageContent to which the WS-Security header will be
     *            added.
     * @param username The WS-Security username.
     * @param password The WS-Security password.
     * @throws java.lang.RuntimeException This exception will be thrown if a
     *             SOAPException occurs when modifying the message.
     */
    private void addWSSecurityHeader(SOAPMessageContext smc, String username, String password)
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

            SOAPElement heSecurity = header.addChildElement("Security", WSSEPrefix, WSSENamespace);
            heSecurity.addAttribute(message.getSOAPPart().getEnvelope().createName("mustUnderstand",
                SOAPENVPrefix, SOAPENVNamespace), "1");

            SOAPElement heUsernameToken = heSecurity.addChildElement("UsernameToken", WSSEPrefix,
                WSSENamespace);

            heUsernameToken.addChildElement("Username", WSSEPrefix, WSSENamespace).addTextNode(username);

            SOAPElement hePassword = heUsernameToken.addChildElement("Password", WSSEPrefix, WSSENamespace);
            
            
            hePassword.addAttribute(message.getSOAPPart().getEnvelope().createName("Type"), WSSEPasswordText);
            hePassword.addTextNode(password);

        }
        catch (SOAPException e)
        {
            throw new RuntimeException("Failed to add WS-Security header to request", e);
        }
    }
}

	