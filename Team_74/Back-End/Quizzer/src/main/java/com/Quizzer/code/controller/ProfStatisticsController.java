package com.Quizzer.code.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.Quizzer.code.model.response.StatisticsResponseVO;
import com.Quizzer.code.service.ProfStatisticsService;

@RestController
public class ProfStatisticsController {

	@Autowired
	ProfStatisticsService profStatisticsService;

	@RequestMapping(method = RequestMethod.GET, value = "/prof/stats")
	public ResponseEntity<?> getStatistics() {

		return new ResponseEntity<StatisticsResponseVO>(profStatisticsService.calculateStats(), HttpStatus.ACCEPTED);
	}
}
