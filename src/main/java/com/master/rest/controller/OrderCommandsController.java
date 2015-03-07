package com.master.rest.controller;

import java.security.Principal;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.master.core.demain.Buying;
import com.master.core.demain.Selling;
import com.master.core.service.BuyingService;
import com.master.core.service.SellingService;



@Controller
public class OrderCommandsController {
	
	private static final Logger logger = Logger.getLogger(OrderCommandsController.class);
	
	
	@Resource
	private BuyingService buyingService;
	
	@Resource
	private SellingService sellingService;
	
	/*
	 * Buying
	 */
	@RequestMapping(method = RequestMethod.POST, value = "order/buying")
	public ResponseEntity<?> addBuying(Principal principal,@RequestBody Buying buying) {
		String username = principal.getName();
		buyingService.addBuying(buying);
		logger.info(username+" added an order");
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "order/buying")
	public ResponseEntity<?> updateBuying(Principal principal,@RequestBody Buying buying) {
		buyingService.updateBuying(buying);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "order/buying/{id}")
	public ResponseEntity<?> deleteBuying(Principal principal,@PathVariable long id) {
		buyingService.deleteBuying(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	
	/*
	 * Selling
	 */
	@RequestMapping(method = RequestMethod.POST, value = "order/selling")
	public ResponseEntity<?> addSelling(Principal principal,@RequestBody Selling selling) {
		String username = principal.getName();
		sellingService.addSelling(selling);
		logger.info(username+" added an order");
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "order/selling")
	public ResponseEntity<?> updateSelling(Principal principal,@RequestBody Selling selling) {
		sellingService.updateSelling(selling);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "order/selling/{id}")
	public ResponseEntity<?> deleteSelling(Principal principal,@PathVariable long id) {
		sellingService.deleteSelling(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	
}
