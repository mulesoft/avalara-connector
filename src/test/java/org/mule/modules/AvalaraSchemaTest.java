/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.modules;

import org.junit.Test;
import org.mule.tck.junit4.FunctionalTestCase;

public class AvalaraSchemaTest extends FunctionalTestCase {

    @Override
    protected String getConfigResources() {
        return "avalara-schema-test.xml";
    }

    @Test
    public void testCanParseXmlWithoutSchemaValidationErrors() throws Exception {
        //Nothing. Will fail if can not parse        
    }

}
