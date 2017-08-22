/*******************************************************************************
 * Copyright (c) 2017, Autonomous Networks Research Group. All rights reserved.
 * contributor: Vishal D. Rahane
 * Read license file in main directory for more details
 ******************************************************************************/
package com.vis.models;

/**
 * @author vis
 *
 */
public class UnsubscribeResponse {

	private boolean isUnsubscribed;

	public UnsubscribeResponse() {
		isUnsubscribed = true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UnsubscribeResponse [isUnsubscribed=").append(isUnsubscribed).append("]");
		return builder.toString();
	}

	public boolean isUnsubscribed() {
		return isUnsubscribed;
	}

	public void setUnsubscribed(boolean isUnsubscribed) {
		this.isUnsubscribed = isUnsubscribed;
	}

}
