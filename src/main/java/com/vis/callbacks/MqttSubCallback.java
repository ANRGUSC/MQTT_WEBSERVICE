/*******************************************************************************
 * Copyright (c) 2017, Autonomous Networks Research Group. All rights reserved.
 * contributor: Vishal D. Rahane
 * Read license file in main directory for more details
 ******************************************************************************/
/**
 * 
 */
package com.vis.callbacks;

import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author vis
 *
 */
public class MqttSubCallback implements MqttCallback {

	private static final Logger LOGGER = LogManager.getLogger(MqttSubCallback.class.getName());

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public void connectionLost(Throwable cause) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {

	}

	@Override
	public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
		// get urls from redis for this topic and hit the url;
		try {
			Iterator<Object> urlsIterator = redisTemplate.opsForSet().members(topic).iterator();
			while (urlsIterator.hasNext()) {
				makeHttpCall((String) urlsIterator.next(), mqttMessage);
			}
		} catch (Exception ex) {
			LOGGER.error("Exception while sending data to the client-", ex);
		}
	}

	private void makeHttpCall(String url, MqttMessage mqttMessage) throws Exception {
		UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(url).queryParam("message", mqttMessage).build();
		restTemplate.getForObject(uriComponents.toString(), String.class);
	}

}
