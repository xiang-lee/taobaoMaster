package com.master.core.event.user;

import com.master.core.demain.User;
import com.master.core.event.UpdateEvent;

public class UpdateUserEvent extends UpdateEvent{
	
	private long id;

	private User user;
	

	public UpdateUserEvent() {
	}
	
	public static UpdateUserEvent notFound() {
		UpdateUserEvent ue = new UpdateUserEvent();
		ue.setEntityFound(false);
	    return ue;
	}
	
	public UpdateUserEvent(long id, User user) {
		this.id = id;
		this.user = user;
	}

	public long getId() {
		return id;
	}
	
	public User getUser() {
		return user;
	}
}
