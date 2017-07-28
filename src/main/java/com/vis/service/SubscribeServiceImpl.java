/*******************************************************************************
 * Copyright (c) 2017, Autonomous Networks Research Group. All rights reserved.
 * contributor: Vishal D. Rahane
 * Read license file in main directory for more details
 ******************************************************************************/
/**
 * 
 */
package com.vis.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.vis.models.SubscriptionRequest;
import com.vis.models.SubscriptionResponse;

/**
 * @author vis
 *
 */
@Service
public class SubscribeServiceImpl implements SubscribeService {

	private static final Logger LOGGER = LogManager.getLogger(SubscribeServiceImpl.class.getName());

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Autowired
	@Qualifier("MqttClientSub")
	private MqttClient mqttClient;

	@Override
	public SubscriptionResponse subscribeToTopic(SubscriptionRequest subscriptionRequest) {
		SubscriptionResponse subscriptionResponse = new SubscriptionResponse();
		boolean isRegistered = registerUrl(subscriptionRequest);
		if (isRegistered) {
			subscriptionResponse = subscribe(subscriptionRequest);
		} else {
			subscriptionResponse.setSubscribed(false);
		}
		return subscriptionResponse;

	}

	private SubscriptionResponse subscribe(SubscriptionRequest subscriptionRequest) {
		SubscriptionResponse subscriptionResponse = new SubscriptionResponse();
		try {
			mqttClient.subscribe(subscriptionRequest.getTopic());
		} catch (MqttException e) {
			subscriptionResponse.setSubscribed(false);
			LOGGER.error("Exception while publishing data-", e);
		}
		return subscriptionResponse;

	}

	private boolean registerUrl(SubscriptionRequest subscriptionRequest) {
		// put topic:url mapping in the cache
		boolean result = true;
		try {
			redisTemplate.opsForValue().set(subscriptionRequest.getTopic(), subscriptionRequest.getCallbackUrl());
		} catch (Exception ex) {
			LOGGER.error("Exception while persisting callback info to redis-" + ex);
			result = false;
		}
		return result;
	}

}
