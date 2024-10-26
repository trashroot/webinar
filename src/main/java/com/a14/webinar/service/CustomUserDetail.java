package com.a14.webinar.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.a14.webinar.entity.User;

public class CustomUserDetail implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	private User user;
	
	public CustomUserDetail(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		SimpleGrantedAuthority grant = new SimpleGrantedAuthority("ROLE_USER");
		return Arrays.asList(grant);
	}

	@Override
	public String getPassword() {		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

}
