/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules;

import org.junit.Test;
import org.mule.api.processor.MessageProcessor;
import org.mule.tck.junit4.FunctionalTestCase;

/**
 * @author Gaston Ponti
 * @since Nov 23, 2011
 */

public class AvalaraGetTaxHistoryTestDriver extends FunctionalTestCase {
    /** @see org.mule.tck.FunctionalTestCase#getConfigResources() */
    @Override
    protected String getConfigResources() {
            return "avalara-get-tax-history-test.xml";
    }

    @Test
    public void testFlow() throws Exception {
        ((MessageProcessor)this.getFlowConstruct("main")).process(getTestEvent(""));
    }
}
