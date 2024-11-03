package com.a14.webinar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.a14.webinar.service.CustomUserDetailService;

@Configuration
@EnableWebSecurity(debug=false)
public class AuthConfig {
	
	@Autowired
	private CustomUserDetailService userservice;
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

 	@Bean
 	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
 		http.csrf((cs) -> cs.disable());
// 		http.authorizeHttpRequests((request) -> 
// 					request.requestMatchers("/","/account/login","/account/register","/css/**","/js/**","/img/**","/fonts/**")
// 					.permitAll()
// 					.anyRequest().authenticated());
// 		http.userDetailsService(userservice);
// 		http.formLogin(form -> form.loginPage("/account/login").permitAll()
// 									.loginProcessingUrl("/account/loginaccount")
// 									.defaultSuccessUrl("/manage/list"));
// 		http.logout(LogoutConfigurer::permitAll);
 		return http.build();

 	}

}
