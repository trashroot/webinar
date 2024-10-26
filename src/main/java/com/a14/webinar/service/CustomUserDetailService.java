package com.a14.webinar.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.a14.webinar.entity.User;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	private UserService userservice;
	
	public CustomUserDetailService(UserService userservice) {
		this.userservice = userservice;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User usr = userservice.getUserByEmail(username);
		
		if(usr == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		return new CustomUserDetail(usr);
	}

}
