package com.example.app.auth;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		if("divya".equals(username) && "divya123".equals(password)) {
			return new UsernamePasswordAuthenticationToken(username, password,Arrays.asList());
		}else {
		throw new BadCredentialsException("Invalid username and password");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	
	
}
