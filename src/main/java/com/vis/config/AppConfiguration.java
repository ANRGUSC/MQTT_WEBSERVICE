/*******************************************************************************
 * Copyright (c) 2017, Autonomous Networks Research Group. All rights reserved.
 * contributor: Vishal D. Rahane
 * Read license file in main directory for more details
 ******************************************************************************/
package com.vis.config;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;

import com.vis.callbacks.MqttSubCallback;

@Configuration
public class AppConfiguration {

	@Value("${mqtt.client}")
	private String mqttClientId;

	@Value("${mqtt.broker}")
	private String mqttBroker;

	@Value("${mqtt.port}")
	private String mqttPort;

	@Value("${mqtt.username?:\"\"}")
	private String mqttUsername;

	@Value("${mqtt.password?:\"\"}")
	private String mqttPassword;

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public JedisConnectionFactory getJedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	public RedisTemplate<String, Object> getRedisTemplate() {
		final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		template.setConnectionFactory(getJedisConnectionFactory());
		return template;
	}
	
	@Bean
	public MqttSubCallback getMqttCallback() {
		return new MqttSubCallback();
	}

	@Bean(name = "MqttClientPub")
	public MqttClient getMqttClientPub() throws MqttException {
		MqttClient mqttClient = new MqttClient("tcp://" + mqttBroker + ":" + mqttPort, mqttClientId + "Pub");
		MqttConnectOptions connOptions = getConnectionOption();
		mqttClient.connect(connOptions);
		return mqttClient;
	}

	@Bean(name = "MqttClientSub")
	public MqttClient getMqttClientSub() throws MqttException {
		MqttClient mqttClient = new MqttClient("tcp://" + mqttBroker + ":" + mqttPort, mqttClientId + "Sub");
		MqttConnectOptions connOptions = getConnectionOption();
		mqttClient.connect(connOptions);
		mqttClient.setCallback(getMqttCallback());
		return mqttClient;
	}

	private MqttConnectOptions getConnectionOption() {
		MqttConnectOptions connOptions = new MqttConnectOptions();
		connOptions.setUserName(mqttUsername);
		connOptions.setPassword(mqttPassword.toCharArray());
		connOptions.setCleanSession(false);
		connOptions.setAutomaticReconnect(true);
		return connOptions;
	}

}
