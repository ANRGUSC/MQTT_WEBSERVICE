/*******************************************************************************
 * Copyright (c) 2017, Autonomous Networks Research Group. All rights reserved.
 * contributor: Vishal D. Rahane
 * Read license file in main directory for more details
 ******************************************************************************/
package com.vis.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author vis
 *
 */
public class RedisCacheUrlModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Set<String> urlSet;

	public RedisCacheUrlModel() {
		urlSet = new HashSet<String>();
	}

	public Set<String> getUrlSet() {
		return urlSet;
	}

	public void addToUrlSet(String url) {
		urlSet.add(url);
	}

}
