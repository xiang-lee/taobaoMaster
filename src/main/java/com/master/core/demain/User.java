package com.master.core.demain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "da_user")	
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
	private long id;
	private String username;
	private String name="";
	private String password;
	private String role;

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

	
}
