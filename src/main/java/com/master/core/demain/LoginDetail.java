package com.master.core.demain;

public class LoginDetail {
	private String username;
	private String password;
	private String base64Auth;
	public String getBase64Auth() {
		return base64Auth;
	}
	public String getPassword() {
		return password;
	}
	public String getUsername() {
		return username;
	}
	public void setBase64Auth(String base64Auth) {
		this.base64Auth = base64Auth;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "LoginDetail [username=" + username + ", password=" + password
				+ ", base64Auth=" + base64Auth + "]";
	}
	
	
}
