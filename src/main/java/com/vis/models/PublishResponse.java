/**
 * 
 */
package com.vis.models;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Vis
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PublishResponse {

	private boolean isPublished;

	public PublishResponse() {
		isPublished = true;
	}

	public boolean isPublished() {
		return isPublished;
	}

	public void setPublished(boolean isPublished) {
		this.isPublished = isPublished;
	}

}
