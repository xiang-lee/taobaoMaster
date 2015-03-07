package com.master.core.service;

import com.master.core.demain.LoginDetail;
import com.master.core.demain.User;
import com.master.core.event.user.ViewUserEvent;


public interface UserService {

	ViewUserEvent findByUsername(String username);

	User login(LoginDetail loginDetail);

	void updateUser(User user);
}
