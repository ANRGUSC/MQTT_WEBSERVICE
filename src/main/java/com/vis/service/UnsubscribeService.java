/*******************************************************************************
 * Copyright (c) 2017, Autonomous Networks Research Group. All rights reserved.
 * contributor: Vishal D. Rahane
 * Read license file in main directory for more details
 ******************************************************************************/
package com.vis.service;

import com.vis.models.UnsubscribeRequest;
import com.vis.models.UnsubscribeResponse;

/**
 * @author vis
 *
 */
public interface UnsubscribeService {

	UnsubscribeResponse unsubscribe(UnsubscribeRequest unsubscribeRequest);

}
