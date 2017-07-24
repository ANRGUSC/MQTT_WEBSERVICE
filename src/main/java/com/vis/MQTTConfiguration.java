/**
 * 
 */
package com.vis;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Vis
 *
 */
@Configuration
public class MQTTConfiguration {

	@Value("${mqtt.client}")
	private String MQTT_CLIENT_ID;

	@Value("${mqtt.broker}")
	private String mqttBroker;

	@Value("${mqtt.port}")
	private String mqttPort;

	@Value("${mqtt.username?:\"\"}")
	private String mqttUsername;

	@Value("${mqtt.password?:\"\"}")
	private String mqttPassword;
	
	@Bean
	public MqttClient mqttClient() throws MqttException {
		MqttClient mqttClient = new MqttClient("tcp://" + mqttBroker + ":" + mqttPort, MQTT_CLIENT_ID);
		MqttConnectOptions connOptions = getConnectionOption();
		mqttClient.connect(connOptions);
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
