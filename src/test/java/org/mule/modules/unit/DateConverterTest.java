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

package org.mule.modules.unit;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.mule.modules.utils.mom.JaxbMapObjectMappers;

import com.avalara.avatax.services.GetTaxRequest;
import com.zauberlabs.commons.mom.MapObjectMapper;

/**
 * @author Gaston Ponti
 * @since Oct 19, 2011
 */
public class DateConverterTest
{
    @Test
    public void converterTest()
    {
        MapObjectMapper mom = JaxbMapObjectMappers.defaultWithPackage("com.avalara.avatax.services").build();
        Map<String, Object> map = new HashMap<String, Object>()
        { {
            put("docDate", "2001-01-01T10:10:10Z");
        } };
        
        GetTaxRequest getTax = (GetTaxRequest) mom.unmap(map, GetTaxRequest.class);
        
        assertEquals(2001, getTax.getDocDate().getYear());
        
        
    }
}
