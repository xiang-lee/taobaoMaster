package com.master.core.event.user;

import com.master.core.demain.User;
import com.master.core.event.CreatefEvent;

public class CreateUserEvent extends CreatefEvent{
	private long id;
	private User user;
	
	public CreateUserEvent(long id) {
		this.id = id;
	}

	public CreateUserEvent(long id, User user) {
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
