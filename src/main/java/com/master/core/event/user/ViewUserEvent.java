package com.master.core.event.user;

import com.master.core.demain.User;
import com.master.core.event.ViewEvent;

public class ViewUserEvent extends ViewEvent{
	
	public static ViewUserEvent notFound() {
		ViewUserEvent ue = new ViewUserEvent();
		ue.setEntityFound(false);
	    return ue;
	}
	
	public static ViewUserEvent notFound(long id) {
		ViewUserEvent ue = new ViewUserEvent(id);
		ue.setEntityFound(false);
	    return ue;
	}
	
	public static ViewUserEvent notFound(String username) {
		ViewUserEvent ue = new ViewUserEvent(username);
		ue.setEntityFound(false);
	    return ue;
	}
	
	private long id;
	private String username;

	private User user;

	
	public ViewUserEvent() {}
	
	public ViewUserEvent(long id) {
		this.id = id;
	}
	
	public ViewUserEvent(long id, User user) {
		this.id = id;
		this.user = user;
	}
	
	public ViewUserEvent(String username) {
		this.username = username;
	}
	
	
	public ViewUserEvent(String username, User user) {
		this.username = username;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}
	
	public String getUsername() {
		return username;
	}
}
