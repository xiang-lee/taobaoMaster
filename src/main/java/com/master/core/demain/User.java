package com.master.core.demain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.master.core.util.EncodeUtil;


@Entity
@Table(name = "tm_user")	
public class User {
	private long id;
	private String username;
	private String name="";
	private String password;
	private String role = "ROLE_USER";
	@Id
    @GeneratedValue
    @Column(name = "id")
	public long getId() {
		return id;
	}
	@Column(name = "name")
	public String getName() {
		return name;
	}
	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	@Column(name = "role")
	public String getRole() {
		return role;
	}

	@Column(name = "username")
	public String getUsername() {
		return username;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void updateDetail(User user) {
		if(!password.equals(user.getPassword())) {
			password = EncodeUtil.encodeByBCrypt(user.getPassword());
		}
		if(user.getName().length() > 0) name = user.getName();
	}
}
