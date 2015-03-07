package com.master.rest.controller;

import java.security.Principal;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.master.core.demain.Buying;
import com.master.core.demain.Selling;
import com.master.core.service.BuyingService;
import com.master.core.service.SellingService;


@Controller
public class OrderQueriesController {
	
	@Resource
	private BuyingService buyingService;
	@Resource
	private SellingService sellingService;
	
	/*
	 * Buying
	 */
	@RequestMapping(method = RequestMethod.GET, value = "order/buying/{id}")
	public ResponseEntity<?> addBuying(Principal principal,@PathVariable long id) {
		Buying buying = buyingService.findById(id);
		return new ResponseEntity<Buying>(buying,HttpStatus.OK);
	}
	
	
	/*
	 * Selling
	 */
	@RequestMapping(method = RequestMethod.GET, value = "order/selling/{id}")
	public ResponseEntity<?> addSelling(Principal principal,@PathVariable long id) {
		Selling selling = sellingService.findById(id);
		return new ResponseEntity<Selling>(selling,HttpStatus.OK);
	}
	
}
