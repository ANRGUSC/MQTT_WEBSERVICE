/**
 * 
 */
package com.vis.api;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vis.models.SubscriptionRequest;
import com.vis.models.SubscriptionResponse;
import com.vis.service.SubscribeService;

/**
 * @author Vis
 *
 */
@RestController
@RequestMapping(value="subscribe")
public class SubscribeController {

	private static final Logger LOGGER = LogManager.getLogger(SubscribeController.class.getName());

	@Autowired
	private SubscribeService subscribeService;

	@RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
	public SubscriptionResponse subscribe(@Valid SubscriptionRequest subscriptionRequest) {
		SubscriptionResponse subscriptionResponse = subscribeService.subscribeToTopic(subscriptionRequest);
		LOGGER.info("Request to subscribe data-" + subscriptionRequest + " Response-" + subscriptionResponse);
		return subscriptionResponse;
	}  
}
