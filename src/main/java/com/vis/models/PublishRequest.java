/**
 * 
 */
package com.vis.models;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Vis
 *
 */
public class PublishRequest {

	@NotEmpty
	private String topic;
	
	@NotEmpty
	private String message;

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PublishRequest [topic=").append(topic).append(", message=").append(message).append("]");
		return builder.toString();
	}

}
