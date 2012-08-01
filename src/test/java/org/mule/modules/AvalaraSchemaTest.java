/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules;

import org.junit.Test;
import org.mule.tck.FunctionalTestCase;

public class AvalaraSchemaTest extends FunctionalTestCase
{
    @Override
    protected String getConfigResources()
    {
        return "avalara-schema-test.xml";
    }

    @Test
    public void testCanParseXmlWithoutSchemaValidationErrors() throws Exception
    {
        //Nothing. Will fail if can not parse        
    }
 
}
