package com.master.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.master.core.dao.UserDao;
import com.master.core.demain.LoginDetail;
import com.master.core.demain.User;
import com.master.core.event.user.ViewUserEvent;
import com.master.core.service.UserService;


@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public ViewUserEvent findByUsername(String username) {
		User user = userDao.findByUsername(username);
		if(user == null) {
			return ViewUserEvent.notFound(username);
		}
		return new ViewUserEvent(username,user);
	}

	@Override
	public User login(LoginDetail loginDetail) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
