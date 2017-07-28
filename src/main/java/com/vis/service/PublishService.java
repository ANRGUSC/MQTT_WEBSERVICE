/*******************************************************************************
 * Copyright (c) 2017, Autonomous Networks Research Group. All rights reserved.
 * contributor: Vishal D. Rahane
 * Read license file in main directory for more details
 ******************************************************************************/
/**
 * 
 */
package com.vis.service;

import com.vis.models.PublishRequest;
import com.vis.models.PublishResponse;

/**
 * @author Vis
 *
 */

public interface PublishService {

	PublishResponse publishData(PublishRequest publishRequest);

}
