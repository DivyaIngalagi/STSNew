package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {//creating users
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication()
		.withUser("alex").password(passwordEncoder.encode("alex123")).roles("USER")
		.and()
		.withUser("anna").password(passwordEncoder.encode("anna123")).roles("ADMIN")
		.and()
		.passwordEncoder(passwordEncoder);
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.formLogin();
		http.authorizeRequests()
		.antMatchers("/admin/dashboard/**")
//		.hasAuthority("ROLE_ADMIN")
		.hasRole("ADMIN")
		.antMatchers("/user/dashboard/**")
		.hasAnyRole("ADMIN","USER")
		.anyRequest()
		.permitAll();
	}

	
	
}









//antMatcher match url
//if adimn has a right to acces each and ever part of the application if we want to restict admin part separately and user part separately
//so,we can;t write here role for the admin .hasRole("") so we have to write like this .hasRole("ADMIN","USER")