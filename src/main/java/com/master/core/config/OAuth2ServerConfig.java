/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.master.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import com.master.core.oauth.SddUserApprovalHandler;

/**
 * @author Xiang Li
 * 
 */
@Configuration
public class OAuth2ServerConfig {

	private static final String DRESSADS_RESOURCE_ID = "dressAds";


	@Configuration
	@EnableResourceServer
	protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
		
		@Override
		public void configure(ResourceServerSecurityConfigurer resources) {
			resources.resourceId(DRESSADS_RESOURCE_ID);
		}

		@Override
		public void configure(HttpSecurity http) throws Exception {
			// @formatter:off
			http
//				.addFilterBefore(new SimpleCORSFilter(),ChannelProcessingFilter.class)
				.requestMatchers().antMatchers("/admin/**","/user/**","/merchant/**", "/oauth/users/**", "/oauth/clients/**","/me")
			.and()
				.authorizeRequests()
				
				
//.antMatchers("/login/**").access("#oauth2.hasScope('read')")
.antMatchers("/user/**").access("#oauth2.hasScope('read')")
.antMatchers("/admin/**").access("#oauth2.hasScope('read')")
				
.antMatchers("/admin/**").hasAnyRole("ADMIN")
					.antMatchers("/me").access("#oauth2.hasScope('read')")
					.antMatchers("/photos").access("#oauth2.hasScope('read')")
					.antMatchers("/photos/trusted/**").access("#oauth2.hasScope('trust')")
					.antMatchers("/photos/user/**").access("#oauth2.hasScope('trust')")
					.regexMatchers(HttpMethod.DELETE, "/oauth/users/([^/].*?)/tokens/.*")
						.access("#oauth2.clientHasRole('ROLE_CLIENT') and (hasRole('ROLE_USER') or #oauth2.isClient()) and #oauth2.hasScope('write')")
					.regexMatchers(HttpMethod.GET, "/oauth/clients/([^/].*?)/users/.*")
						.access("#oauth2.clientHasRole('ROLE_CLIENT') and (hasRole('ROLE_USER') or #oauth2.isClient()) and #oauth2.hasScope('read')")
					.regexMatchers(HttpMethod.GET, "/oauth/clients/.*")
						.access("#oauth2.clientHasRole('ROLE_CLIENT') and #oauth2.isClient() and #oauth2.hasScope('read')");
			// @formatter:on
		}

	}

	
	
	
	
	@Configuration
	@EnableAuthorizationServer
	protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

		@Autowired
		private TokenStore tokenStore;

		@Autowired
		private UserApprovalHandler userApprovalHandler;

		@Autowired
		@Qualifier("authenticationManagerBean")
		private AuthenticationManager authenticationManager;

		@Value("${tonr.redirect:http://localhost:8081/tonr2/sparklr/redirect}")
		private String tonrRedirectUri;

		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			// @formatter:off
			clients.inMemory()
			 			.withClient("sdd")
			 			.resourceIds(DRESSADS_RESOURCE_ID)
			 			.authorizedGrantTypes("password","authorization_code", "implicit")
//			 			.authorities("ROLE_CLIENT")
			 			.authorities("USER")
			 			.scopes("read", "write")
			 			.secret("sdd_secret")
			 			.accessTokenValiditySeconds(86400); //expire in one day
			// @formatter:on
		}

		@Bean
		public TokenStore tokenStore() {
			return new InMemoryTokenStore();
		}

		@Bean
		@Primary
	    public ResourceServerTokenServices tokenServices() {
			
	        DefaultTokenServices tokenServices = new DefaultTokenServices();
	        tokenServices.setSupportRefreshToken(true);
	        tokenServices.setTokenStore(this.tokenStore);
	        return tokenServices;
	    } 
		
		@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
			endpoints.tokenStore(tokenStore).userApprovalHandler(userApprovalHandler)
					.authenticationManager(authenticationManager);
		}

		@Override
		public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
			oauthServer.realm("sparklr2/client");
//			oauthServer.tokenKeyAccess("isAnonymous() || hasAuthority('ROLE_TRUSTED_CLIENT')").checkTokenAccess(
//                    "hasAuthority('ROLE_TRUSTED_CLIENT')");
		}

	}
	
	protected static class Stuff {
	
		@Autowired
		private ClientDetailsService clientDetailsService;

		@Autowired
		private TokenStore tokenStore;

		@Bean
		public ApprovalStore approvalStore() throws Exception {
			TokenApprovalStore store = new TokenApprovalStore();
			store.setTokenStore(tokenStore);
			return store;
		}

		@Bean
		@Lazy
		@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
		public SddUserApprovalHandler userApprovalHandler() throws Exception {
			SddUserApprovalHandler handler = new SddUserApprovalHandler();
			handler.setApprovalStore(approvalStore());
			handler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
			handler.setClientDetailsService(clientDetailsService);
			handler.setUseApprovalStore(true);
			return handler;
		}
	}

}
