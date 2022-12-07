package com.spring.jwt.api.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.spring.jwt.api.service.CustomUserDetailsService;
import com.spring.jwt.api.util.JwtUtil;

public class JWTFilter extends OncePerRequestFilter{

	//take request authorization we have started with bearer which intercept our request
	
	@Autowired
	private JwtUtil jwtutil;
	@Autowired
	private CustomUserDetailsService service;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String authorizationHeader = request.getHeader("Authorization");
		String token = null;
		String userName = null;
		
		if(authorizationHeader!=null&&authorizationHeader.startsWith("Bearer")) {
			token = authorizationHeader.substring(7);
			userName = jwtutil.extractUsername(token);
		}
		
		if(userName!=null&&SecurityContextHolder.getContext().getAuthentication()) {
			UserDetails userDetails = service.loadUserByUsername(username);
			
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
					new UsernamePasswordAuthenticationToken(userDetails,null, credentials);
			
			usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(context));
		}
	}
	
	
}
