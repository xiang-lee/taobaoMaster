package com.master.core.demain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.social.security.SocialUser;

public class MyUserDetails extends SocialUser  {
	private Long id;
    private String firstName;
    private String lastName;
    private String role;

	
	public MyUserDetails(String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public static Builder getBuilder() {
        return new Builder();
    }

	
    
    
    public static class Builder {

        private Long id;

        private String username;

        private String firstName;

        private String lastName;

        private String password;
        private String role;


        private Set<GrantedAuthority> authorities;

        public Builder() {
            this.authorities = new HashSet<GrantedAuthority>();
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder password(String password) {
            if (password == null) {
                password = "SocialUser";
            }

            this.password = password;
            return this;
        }


        public Builder role(String role) {
            this.role = role;

            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
            this.authorities.add(authority);

            return this;
        }
        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public MyUserDetails build() {
        	MyUserDetails user = new MyUserDetails(username, password, authorities);

            user.id = id;
            user.firstName = firstName;
            user.lastName = lastName;
            user.role = role;

            return user;
        }
    }
}
