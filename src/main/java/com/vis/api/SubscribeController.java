/**
 * 
 */
package com.vis.api;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vis.models.SubscriptionRequest;
import com.vis.models.SubscriptionResponse;

/**
 * @author Vis
 *
 */
@RestController
@RequestMapping(value="subscribe")
public class SubscribeController {

	@RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
	public SubscriptionResponse subscribe(@Valid SubscriptionRequest subscriptionRequest) {
		return null;
		
	}  
}
