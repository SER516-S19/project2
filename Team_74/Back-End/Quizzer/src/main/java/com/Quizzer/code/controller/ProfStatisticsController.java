package com.Quizzer.code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.Quizzer.code.model.response.StatisticsResponseVO;
import com.Quizzer.code.service.ProfStatisticsService;

/**
 * This class is the controller that handles requests for statistics
 * 
 * @author Kumar Prabhu Kalyan and Kirti Jha
 *
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProfStatisticsController {

	@Autowired
	ProfStatisticsService profStatisticsService;

	/**
	 * This method handles the fetching of statistics and returns the median and
	 * average of quiz scores.
	 * 
	 * @return
	 */

	@RequestMapping(method = RequestMethod.GET, value = "/prof/stats")
	public ResponseEntity<?> getStatistics() {

		return new ResponseEntity<StatisticsResponseVO>(profStatisticsService.calculateStats(), HttpStatus.ACCEPTED);
	}
}
