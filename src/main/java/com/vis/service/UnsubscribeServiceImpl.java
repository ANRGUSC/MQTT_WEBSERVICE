/*******************************************************************************
 * Copyright (c) 2017, Autonomous Networks Research Group. All rights reserved.
 * contributor: Vishal D. Rahane
 * Read license file in main directory for more details
 ******************************************************************************/
package com.vis.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.vis.models.UnsubscribeRequest;
import com.vis.models.UnsubscribeResponse;

/**
 * @author vis
 *
 */
@Service
public class UnsubscribeServiceImpl implements UnsubscribeService {
	@Autowired
	@Qualifier("MqttClientSub")
	private MqttClient mqttClient;

	private static final Logger LOGGER = LogManager.getLogger(UnsubscribeServiceImpl.class.getName());

	@Override
	public UnsubscribeResponse unsubscribe(UnsubscribeRequest unsubscribeRequest) {
		UnsubscribeResponse unsubscribeResponse = new UnsubscribeResponse();
		try {
			mqttClient.unsubscribe(unsubscribeRequest.getTopic());
		} catch (MqttException e) {
			unsubscribeResponse.setUnsubscribed(false);
			LOGGER.error("Exception while unsubscribing data-", e);
		}
		return unsubscribeResponse;
	}

}
