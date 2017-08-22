/*******************************************************************************
 * Copyright (c) 2017, Autonomous Networks Research Group. All rights reserved.
 * contributor: Vishal D. Rahane
 * Read license file in main directory for more details
 ******************************************************************************/
package com.vis.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vis.models.UnsubscribeRequest;
import com.vis.models.UnsubscribeResponse;
import com.vis.service.UnsubscribeService;

/**
 * @author vis
 *
 */
@RestController
@RequestMapping("unsubscribe")
public class UnsubscribeController {
	private static final Logger LOGGER = LogManager.getLogger(UnsubscribeController.class.getName());

	@Autowired
	private UnsubscribeService unsubscribeService;

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	public UnsubscribeResponse unsubscribe(UnsubscribeRequest unsubscribeRequest) {
		UnsubscribeResponse unsubscribeResponse = unsubscribeService.unsubscribe(unsubscribeRequest);
		LOGGER.info("Request to unsubscribe data- {} Response- {}", unsubscribeRequest, unsubscribeResponse);
		return unsubscribeResponse;
	}

}
