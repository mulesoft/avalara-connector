/**
 * Mule Avalara Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


	
	/*
	 * Copyright (c) 2011 Zauber S.A.  -- All rights reserved
	 */
	
	package org.mule.modules;

import org.junit.Test;
import org.mule.api.processor.MessageProcessor;
import org.mule.tck.AbstractMuleTestCase;
import org.mule.tck.FunctionalTestCase;

	
/**
 * @author Gaston Ponti
 * @since Nov 23, 2011
 */

public class AvalaraGetTaxHistoryTestDriver extends FunctionalTestCase
{
    
    /** @see org.mule.tck.FunctionalTestCase#getConfigResources() */
    @Override
    protected String getConfigResources()
    {
            return "avalara-get-tax-history-test.xml";
    }

    @Test
    public void testFlow() throws Exception
    {
        lookupFlowConstruct("main").process(getTestEvent(""));
    }

    /**
     * Retrieve a flow by name from the registry
     *
     * @param name Name of the flow to retrieve
     */
    protected MessageProcessor lookupFlowConstruct(String name)
    {
        return (MessageProcessor) AbstractMuleTestCase.muleContext.getRegistry().lookupFlowConstruct(name);
    }

}

	