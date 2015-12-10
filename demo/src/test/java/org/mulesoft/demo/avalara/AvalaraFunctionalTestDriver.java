/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
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
