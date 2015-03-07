package com.master.rest.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.master.core.demain.LoginDetail;
import com.master.core.demain.Oauth;
import com.master.core.demain.User;
import com.master.core.service.UserService;
import com.master.core.util.PropertityHelper;

@Controller
public class LoginController {
	
	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "public/test")
	public ResponseEntity<?> test() {
		return new ResponseEntity<String>("test!!!",HttpStatus.OK);
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "login")
    public ResponseEntity<?> login(@RequestBody LoginDetail loginDetail){
		User user = userService.login(loginDetail);
		if(user == null) {
			return new ResponseEntity<Oauth>(HttpStatus.FORBIDDEN);
		}
		Oauth oauth = null;
		try {
			oauth = getOauth(loginDetail.getUsername(),loginDetail.getPassword(),loginDetail.getBase64Auth(), user);
			logger.info(loginDetail.getUsername()+" Login");
		} catch (Exception e) {
			logger.error("Exception in login", e);
			e.printStackTrace();
		} 
		return new ResponseEntity<Oauth>(oauth, HttpStatus.OK);
	}
	
	
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "logout")
	public void logout (HttpServletRequest request, HttpServletResponse response) {
      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
      if (auth != null){    
         new SecurityContextLogoutHandler().logout(request, response, auth);
      }
	}
	
	
	
	private Oauth getOauth(String username, String password, String base64Quth,User user) throws ClientProtocolException, IOException {
		PropertityHelper ph = new PropertityHelper();
		String ACCESS_TOKEN_URL = ph.getAccessTokenURL();
	
		String url = ACCESS_TOKEN_URL+"?grant_type=password&username="+username+"&password="+password;
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Content-Type", "application/json");
		httpGet.setHeader("Authorization", "Basic "+base64Quth);
		HttpResponse response = httpClient.execute(httpGet);
		String responseString = new BasicResponseHandler().handleResponse(response);
		//Get access token
		JSONObject jsonObj = new JSONObject(responseString);	
		String accessToken = jsonObj.getString("access_token");
		
		Oauth oauth = new Oauth();
		oauth.setToken(accessToken);
		oauth.setUser(user);
		return oauth;
	}
	
	
	
	
	
}
