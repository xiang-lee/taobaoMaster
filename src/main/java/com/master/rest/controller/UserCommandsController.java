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

import com.master.core.demain.User;
import com.master.core.service.UserService;



@Controller
public class UserCommandsController {
	
	private static final Logger logger = Logger.getLogger(UserCommandsController.class);
	
	@Resource
	private UserService userService;
	
	
	//update Profile
	@RequestMapping(method = RequestMethod.POST, value = "user/profile")
	public ResponseEntity<?> updateProfile(Principal principal,@RequestBody User user) {
		String username = principal.getName();
		if(!username.equals(user.getUsername())) {
			return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
		}
		userService.updateUser(user);
		logger.info(username+" updated the profile");
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	
}
