package com.master.rest.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.master.core.service.BuyingService;


@Controller
public class OrderQueriesController {
	
	@Resource
	private BuyingService buyingService;
	
	
	
}
