/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.avalara.util;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 * @author Gaston Ponti
 * @since Oct 25, 2011
 */

public class AvalaraProfileHandler implements SOAPHandler<SOAPMessageContext> {

    private static final String PROFILE_ELEMENT = "Profile";
    private static final String NAMESPACE = "http://avatax.avalara.com/services";
    private static final String AVALARA_PREFIX = "aval";

    private final String profile;

    /**
     * Creates a SOAPSimpleCredentials handler and initializes the member variables. In
     * most cases, the sign static method should be used instead.
     * 
     * @param client The client for the system user.
     */
    public AvalaraProfileHandler(final String profile) {
        this.profile = profile;
    }

    /**
     * Returns null as this handler doesn't process any Headers, it just adds one.
     */
    public Set<QName> getHeaders() {
        return null;
    }

    /**
     * Adds WS-Security header to request messages.
     */
    public boolean handleMessage(SOAPMessageContext smc) {
        Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (outboundProperty.booleanValue()) {
            addProfileHeader(smc, profile);
        }
        return true;
    }

    /**
     * Returns true, no action is taken for faults messages.
     */
    public boolean handleFault(SOAPMessageContext smc) {
        return true;
    }

    public void close(MessageContext messageContext) {
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
    private void addProfileHeader(SOAPMessageContext smc, String client) {
        try {
            // Get the SOAP Header
            SOAPMessage message = smc.getMessage();
            SOAPHeader header = message.getSOAPHeader();
            if (header == null) {
                // Create header as it doesn't already exist
                message.getSOAPPart().getEnvelope().addHeader();
                header = message.getSOAPHeader();
            }

            SOAPElement headerProfile = header.addChildElement(PROFILE_ELEMENT, AVALARA_PREFIX, NAMESPACE);
            headerProfile.addChildElement("Client", AVALARA_PREFIX, NAMESPACE).addTextNode(client);
        }
        catch (SOAPException e) {
            throw new RuntimeException("Failed to add Profile header to request", e);
        }
    }
}
