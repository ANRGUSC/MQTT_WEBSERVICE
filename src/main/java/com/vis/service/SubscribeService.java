/*******************************************************************************
 * Copyright (c) 2017, Autonomous Networks Research Group. All rights reserved.
 * contributor: Vishal D. Rahane
 * Read license file in main directory for more details
 ******************************************************************************/
/**
 * 
 */
package com.vis.service;

import com.vis.models.SubscriptionRequest;
import com.vis.models.SubscriptionResponse;

/**
 * @author vis
 *
 */
public interface SubscribeService {

	SubscriptionResponse subscribeToTopic(SubscriptionRequest subscriptionRequest);
}
