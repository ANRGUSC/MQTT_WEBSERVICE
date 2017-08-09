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

import com.vis.models.SubscribeRequest;
import com.vis.models.SubscribeResponse;

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
	public SubscribeResponse subscribeToTopic(SubscribeRequest subscriptionRequest) {
		SubscribeResponse subscriptionResponse = new SubscribeResponse();
		boolean isRegistered = registerUrl(subscriptionRequest);
		if (isRegistered) {
			subscriptionResponse = subscribe(subscriptionRequest);
		} else {
			subscriptionResponse.setSubscribed(false);
		}
		return subscriptionResponse;

	}

	private SubscribeResponse subscribe(SubscribeRequest subscriptionRequest) {
		SubscribeResponse subscriptionResponse = new SubscribeResponse();
		try {
			mqttClient.subscribe(subscriptionRequest.getTopic());
		} catch (MqttException e) {
			subscriptionResponse.setSubscribed(false);
			LOGGER.error("Exception while subscribing data-", e);
		}
		return subscriptionResponse;

	}

	private boolean registerUrl(SubscribeRequest subscriptionRequest) {
		boolean result = true;
		try {
			// append topic:url mapping to the existing set
			redisTemplate.opsForSet().add(subscriptionRequest.getTopic(), subscriptionRequest.getCallbackUrl());
			
		} catch (Exception ex) {
			LOGGER.error("Exception while persisting callback info to redis-" + ex);
			result = false;
		}
		return result;
	}

}
