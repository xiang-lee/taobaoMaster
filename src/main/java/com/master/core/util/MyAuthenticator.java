package com.master.core.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 
 * @author Xiang
 */
public class MyAuthenticator extends Authenticator {
	private String username;
	private String password;

	public MyAuthenticator(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	}
}
