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
