/**
 * 
 */
package com.vis.service;

import com.vis.models.PublishRequest;
import com.vis.models.PublishResponse;

/**
 * @author Vis
 *
 */

public interface PublishService {

	PublishResponse publishData(PublishRequest publishRequest);

}
