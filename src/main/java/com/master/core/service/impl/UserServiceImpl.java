package com.master.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
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
		String username = loginDetail.getUsername();
		String password = loginDetail.getPassword();
		User user = userDao.findByUsername(username);
		if(user == null) return null;
		if(BCrypt.checkpw(password, user.getPassword())){
			return user;
		}
		return null;
	}

	@Override
	public void updateUser(User user) {
		User newUser = userDao.findById(user.getId());
		newUser.updateDetail(user);
	}
	

}
