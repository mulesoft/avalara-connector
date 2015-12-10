/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
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
