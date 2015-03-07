package com.master.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.master.core.demain.MyUserDetails;
import com.master.core.demain.User;
import com.master.core.event.user.ViewUserEvent;
import com.master.core.service.UserService;


@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		ViewUserEvent viewUserEvent = userService.findByUsername(username);
		if (!viewUserEvent.isEntityFound()) {
            throw new UsernameNotFoundException("No user found with username: " + username);
        }
		User user = viewUserEvent.getUser();
		MyUserDetails principal = MyUserDetails.getBuilder()
				.id(user.getId())
				.password(user.getPassword())
				.role(user.getRole())
				.username(user.getUsername())
				.build();
		
		return principal;
		/*List<GrantedAuthority> authorities = 
                                      buildUserAuthority(user.getRole());
 
		return buildUserForAuthentication(user, authorities);*/
	}
	
	
	// Converts com.mkyong.users.model.User user to
	// org.springframework.security.core.userdetails.User
	/*private User buildUserForAuthentication(UserDB user, 
		List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), 
			user.isEnabled(), true, true, true, authorities);
	}
 
	private List<GrantedAuthority> buildUserAuthority(String userRoles) {
 
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
 
		// Build user's authorities
		setAuths.add(new SimpleGrantedAuthority(userRoles));
 
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
 
		return Result;
	}*/
	
}
