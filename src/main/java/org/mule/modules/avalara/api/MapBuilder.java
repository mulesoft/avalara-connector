/*
 * Copyright (c) 2011 Zauber S.A.  -- All rights reserved
 */

package org.mule.modules.avalara.api;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gaston Ponti
 * @since Oct 18, 2011
 */

public class MapBuilder
{
    private Map<String, Object> map = new HashMap<String, Object>();
    
    /**
     * Creates the QuickBooksModule.EntityBuilder.
     *
     */
               
    public MapBuilder with(String propertyName, Object property)
    {
        map.put(propertyName, property);
        return this;
    }
   
    public Map<String, Object> build()
    {
        return map;
    }
}
