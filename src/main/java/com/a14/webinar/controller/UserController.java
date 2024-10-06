package com.a14.webinar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/manage/login")
	public String login() {
		return "login";
	}

	
}
