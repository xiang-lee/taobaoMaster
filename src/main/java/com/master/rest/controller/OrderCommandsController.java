package com.master.rest.controller;

import java.security.Principal;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.master.core.demain.Buying;
import com.master.core.service.BuyingService;



@Controller
public class OrderCommandsController {
	
	private static final Logger logger = Logger.getLogger(OrderCommandsController.class);
	
	
	@Resource
	private BuyingService buyingService;
	
	
	@RequestMapping(method = RequestMethod.POST, value = "buying")
	public ResponseEntity<?> addBuying(Principal principal,@RequestBody Buying buying) {
		String username = principal.getName();
		buyingService.addBuying(buying);
		logger.info(username+" added an order");
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	
}
