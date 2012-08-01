/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
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
