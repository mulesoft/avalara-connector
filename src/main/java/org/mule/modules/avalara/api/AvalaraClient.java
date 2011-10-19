/*
 * Copyright (c) 2011 Zauber S.A.  -- All rights reserved
 */

package org.mule.modules.avalara.api;

import org.mule.modules.avalara.EntityType;

import com.avalara.avatax.services.BaseResult;

/**
 * @author Gaston Ponti
 * @since Oct 17, 2011
 */

public interface AvalaraClient
{
    <T extends BaseResult> T sendToAvalara(EntityType entityType, Object obj);
}
