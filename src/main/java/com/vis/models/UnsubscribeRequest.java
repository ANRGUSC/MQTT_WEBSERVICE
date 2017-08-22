/*******************************************************************************
 * Copyright (c) 2017, Autonomous Networks Research Group. All rights reserved.
 * contributor: Vishal D. Rahane
 * Read license file in main directory for more details
 ******************************************************************************/

package com.vis.models;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author vis
 *
 */
public class UnsubscribeRequest {

	@NotEmpty
	private String topic;

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UnsubscribeRequest [topic=").append(topic).append("]");
		return builder.toString();
	}

}
