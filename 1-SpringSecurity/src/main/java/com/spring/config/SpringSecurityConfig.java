package com.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("alex").password(passwordEncoder.encode("alex123")).roles("USER")
		.and()
		.withUser("anna").password(passwordEncoder.encode("anna123")).roles("ADMIN")
		.and()
		.passwordEncoder(passwordEncoder);
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
		http.authorizeRequests()
		.antMatchers("/admin/dashboard/**")
		.hasRole("ADMIN")
		.antMatchers("/user/dashboard/**")
		.hasAnyRole("ADMIN","USER")
		.anyRequest()
		.permitAll();
	}
	
	

}
