package com.toystore.ecomm.users.config;

import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	
	  @Override public void configure(HttpSecurity http) throws Exception { 
		  http
		  .authorizeRequests() 
		  .antMatchers(HttpMethod.GET, "/users/**")
	      .hasRole("ADMIN")
		  .anyRequest() .authenticated(); 
	  }
	 
    
	/*
	 * @Override public void configure(ResourceServerSecurityConfigurer resources) {
	 * resources.resourceId("user-management-service").stateless(false); }
	 */
}
