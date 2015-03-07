package com.master.rest.controller;

import java.security.Principal;
import java.util.List;

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
	
	/**
	 * 
	 * Five types of Order:
	 * 
	 * Buying: 1. stockpile (囤货)			isStockpile=true
	 * Buying: 2. Addition (附加)				isStockpile=false
	 * 
	 * 
	 * Selling: 3. Sold(卖出)					isSoldToFriend=false && isBrush=false
	 * Selling: 4. Sold to friend(卖给朋友)	isSoldToFriend=true
	 * Selling: 5. Brush (刷单)				isBrush=true
	 * 
	 */
	
	/*
	 * Stockpile
	 */
	@RequestMapping(method = RequestMethod.GET, value = "order/stockpile")
	public ResponseEntity<?> getAllStockpiles(Principal principal) {
		List<Buying> stockpiles = buyingService.findAllStockpiles();
		return new ResponseEntity<List<Buying>>(stockpiles,HttpStatus.OK);
	}
	
	
	/*
	 * Addition
	 */
	@RequestMapping(method = RequestMethod.GET, value = "order/additions")
	public ResponseEntity<?> getAllAdditions(Principal principal) {
		List<Buying> additions = buyingService.findAllAdditions();
		return new ResponseEntity<List<Buying>>(additions,HttpStatus.OK);
	}
	
	/*
	 * Sold(卖出)
	 */
	@RequestMapping(method = RequestMethod.GET, value = "order/solds")
	public ResponseEntity<?> getAllSells(Principal principal) {
		List<Selling> solds = sellingService.findAllSolds();
		return new ResponseEntity<List<Selling>>(solds,HttpStatus.OK);
	}
	
	
	/*
	 * Sold to friend(卖给朋友)	
	 */
	@RequestMapping(method = RequestMethod.GET, value = "order/soldsToFriend")
	public ResponseEntity<?> getAllSoldsToFriend(Principal principal) {
		List<Selling> soldsToFriend = sellingService.findAllSoldsToFriend();
		return new ResponseEntity<List<Selling>>(soldsToFriend,HttpStatus.OK);
	}
	
	/*
	 * Brush (刷单)
	 */
	@RequestMapping(method = RequestMethod.GET, value = "order/brushes")
	public ResponseEntity<?> getAllBrushes(Principal principal) {
		List<Selling> soldsToFriend = sellingService.findAllBrushes();
		return new ResponseEntity<List<Selling>>(soldsToFriend,HttpStatus.OK);
	}
}
