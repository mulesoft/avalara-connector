/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mulesoft.demo.avalara;

import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.transport.PropertyScope;
import org.mule.tck.junit4.FunctionalTestCase;

import org.junit.Test;

public class AvalaraFunctionalTestDriver extends FunctionalTestCase {
    @Override
    protected String getConfigResources() {
        return "mule-config.xml";
    }

    @Test
    public void getTax() throws Exception {
        MuleEvent event = getTestEvent(null);
        event.getMessage().setProperty("invoiceNumber", "INV00000224", PropertyScope.INBOUND);
        lookupFlowConstruct("GetTaxes").process(event);
    }

    private MessageProcessor lookupFlowConstruct(final String name) {
        return (MessageProcessor) muleContext.getRegistry().lookupFlowConstruct(name);
    }

}
