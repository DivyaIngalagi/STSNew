package com.training.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

import com.training.app.util.KeyCloakRoleConverter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private KeyCloakRoleConverter roleConverter;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/*
		 * http.authorizeRequests() .antMatchers("/api/v1/physicians",
		 * "/api/v1/patients") .hasAuthority("SCOPE_profile") .and()
		 * .oauth2ResourceServer() .jwt();
		 */
		
		JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
		converter.setJwtGrantedAuthoritiesConverter(roleConverter);//it is used for the authentication
		
		http.authorizeRequests()
		      .antMatchers("/api/v1/physicians")
		      .hasRole("admin")
		      .antMatchers("/api/v1/patients")
		      .hasAnyRole("admin", "physician")		      
		      .and()
		      .oauth2ResourceServer()
		      .jwt()		      
		      .jwtAuthenticationConverter(converter);
	}
}





