package com.master.rest.controller;

import java.security.Principal;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.master.core.demain.Statistic;
import com.master.core.service.StatisticService;


@Controller
public class StatisticQueriesController {
	
	@Resource
	private StatisticService statisticService;
	
	/**
	 * statistics (统计)
	 */
	@RequestMapping(method = RequestMethod.GET, value = "order/statistic")
	public ResponseEntity<?> getStatistic(Principal principal) {
		Statistic statistic = statisticService.findStatistic();
		return new ResponseEntity<Statistic>(statistic,HttpStatus.OK);
	}
}
