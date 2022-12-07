package com.training.app.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
//to convert JWT Tokens 
@Component
public class KeyCloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

	@Override
	public Collection<GrantedAuthority> convert(Jwt jwt) {
		
		Map<String, Object> realmAccess =  (Map<String, Object>) jwt.getClaims().get("realm_access");//converting claim into collection
		
		if (realmAccess == null || realmAccess.isEmpty()) 
			return new ArrayList<>();
		
		else  {
			List<String> roles = (List<String>) realmAccess.get("roles");
			
			Collection<GrantedAuthority> allRoles = new ArrayList<>();
			
			for (String role: roles) {
				allRoles.add(new SimpleGrantedAuthority("ROLE_" + role));
			}			
			
			return allRoles;
		}
	}

}
