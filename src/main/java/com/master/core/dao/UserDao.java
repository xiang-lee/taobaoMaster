package com.master.core.dao;

import com.master.core.demain.User;


public interface UserDao {

	User findByUsername(String username);
	
}
