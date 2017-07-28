/*******************************************************************************
 * Copyright (c) 2017, Autonomous Networks Research Group. All rights reserved.
 * contributor: Vishal D. Rahane
 * Read license file in main directory for more details
 ******************************************************************************/
package com.vis.models;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SubscriptionResponse {
	private boolean isSubscribed;

	public SubscriptionResponse() {
		isSubscribed = true;
	}

	public boolean isSubscribed() {
		return isSubscribed;
	}

	public void setSubscribed(boolean isSubscribed) {
		this.isSubscribed = isSubscribed;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SubscriptionResponse [isSubscribed=").append(isSubscribed).append("]");
		return builder.toString();
	}
}
