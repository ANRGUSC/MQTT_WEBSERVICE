/*******************************************************************************
 * Copyright (c) 2017, Autonomous Networks Research Group. All rights reserved.
 * contributor: Vishal D. Rahane
 * Read license file in main directory for more details
 ******************************************************************************/
package com.vis.models;
import org.hibernate.validator.constraints.NotEmpty;

public class SubscribeRequest {

	@NotEmpty
	private String callbackUrl;

	@NotEmpty
	private String topic;

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SubscriptionRequest [callbackUrl=").append(callbackUrl).append(", topic=").append(topic)
				.append("]");
		return builder.toString();
	}

}
