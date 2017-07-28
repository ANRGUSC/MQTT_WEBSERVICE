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
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.vis.models.PublishRequest;
import com.vis.models.PublishResponse;

/**
 * @author Vis
 *
 */
@Service
public class PublishServiceImpl implements PublishService {

	private static final Logger LOGGER = LogManager.getLogger(PublishServiceImpl.class.getName());

	@Autowired
	@Qualifier("MqttClientPub")
	private MqttClient mqttClient;

	@Override
	public PublishResponse publishData(PublishRequest publishRequest) {
		PublishResponse publishResponse = new PublishResponse();
		try {
			mqttClient.publish(publishRequest.getTopic(), new MqttMessage(publishRequest.getMessage().getBytes()));
		} catch (MqttException e) {
			publishResponse.setPublished(false);
			LOGGER.error("Exception while publishing data-", e);
		}
		return publishResponse;
	}

}
