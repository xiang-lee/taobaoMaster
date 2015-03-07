package com.master.rest.demain;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.master.core.demain.User;

public class UserRest {
	private long id;
	private String username;
	private String name="";
	private String password;
	private String firstName="";
	private String passwordPhpass="";
	private String lastName="";
	private String phoneNumber="";
	private String email="";
	private String role;
	private String confirmationId="";
	private boolean isActivated=false;
	private Timestamp userRegistered = new Timestamp(new Date().getTime());
	private String facebookId="";
	public String getConfirmationId() {
		return confirmationId;
	}
	public String getEmail() {
		return email;
	}
	public String getFacebookId() {
		return facebookId;
	}
	public String getFirstName() {
		return firstName;
	}
	
	
	public long getId() {
		return id;
	}
	public String getLastName() {
		return lastName;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}

	public String getPasswordPhpass() {
		return passwordPhpass;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getRole() {
		return role;
	}
	public String getUsername() {
		return username;
	}
	public Timestamp getUserRegistered() {
		return userRegistered;
	}
	public boolean isActivated() {
		return isActivated;
	}
	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPasswordPhpass(String passwordPhpass) {
		this.passwordPhpass = passwordPhpass;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setUserRegistered(Timestamp userRegistered) {
		this.userRegistered = userRegistered;
	}
	
	public User toUser() {
		User user = new User();
	    BeanUtils.copyProperties(this, user);	
	    return user;
	}
}
