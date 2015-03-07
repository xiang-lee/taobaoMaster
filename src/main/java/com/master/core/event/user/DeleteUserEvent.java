package com.master.core.event.user;

import com.master.core.demain.User;
import com.master.core.event.DeleteEvent;

public class DeleteUserEvent extends DeleteEvent{
	
	public static DeleteUserEvent notFound(long id) {
		DeleteUserEvent ue = new DeleteUserEvent(id);
		ue.entityFound=false;
	    return ue;
	}
	private long id;

	private User user;
	
	public DeleteUserEvent(long id) {
		this.id = id;
	}
	
	public DeleteUserEvent(long id, User user) {
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
