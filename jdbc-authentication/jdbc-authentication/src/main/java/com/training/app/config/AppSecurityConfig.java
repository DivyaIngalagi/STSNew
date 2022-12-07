package com.training.app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.jdbcAuthentication() .dataSource(dataSource)
	 * .usersByUsernameQuery("SELECT username, password, enabled FROM customers WHERE username = ?"
	 * )
	 * .authoritiesByUsernameQuery("SELECT username, role FROM roles WHERE username = ?"
	 * ) .passwordEncoder(passwordEncoder); }
	 */
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		       .dataSource(dataSource)
		       .passwordEncoder(passwordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.formLogin();
		http.authorizeRequests()
		      .antMatchers("/api/v1/admin/**")
		      .hasAuthority("ROLE_ADMIN")
		      .antMatchers("/api/v1/user/**")
		      .hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
		      .anyRequest()
		      .permitAll();		      
	}
	
}













