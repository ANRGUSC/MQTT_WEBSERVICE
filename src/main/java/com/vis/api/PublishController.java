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

import com.vis.models.PublishRequest;
import com.vis.models.PublishResponse;
import com.vis.service.PublishService;

/**
 * @author Vis
 *
 */
@RestController
@RequestMapping("publish")
public class PublishController {

	private static final Logger LOGGER = LogManager.getLogger(PublishController.class.getName());

	@Autowired
	private PublishService publishService;

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	public PublishResponse publish(@Valid PublishRequest publishRequest) {
		LOGGER.info("Request to publish data-" + publishRequest);
		PublishResponse publishResponse = publishService.publishData(publishRequest);

		return publishResponse;
	}
}
