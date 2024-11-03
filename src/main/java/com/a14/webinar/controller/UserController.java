package com.a14.webinar.controller;

import java.security.Principal;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.a14.webinar.dto.UserDto;
import com.a14.webinar.entity.User;
import com.a14.webinar.error.ResourceNotFound;
import com.a14.webinar.service.UserService;


@Controller
@RequestMapping("/account")
public class UserController {

	private UserService userService;
	
	private PasswordEncoder passwordEncoder;

	public UserController(UserService userService, PasswordEncoder passwordEncoder) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}

	@GetMapping("/login")
	public String login(Model model, Principal p) {
		UserDto u = new UserDto();
		
		if(p != null && !p.getName().isBlank()) {
			return "redirect:/manage/list";
		}
					
		model.addAttribute("user",u);
		return "user/login";
	}

//	@PostMapping("/validate")
//	public String loginUser(@ModelAttribute("username") String username,
//			@ModelAttribute("password") String password, Model model, HttpSession session) {
//
//		try {
//			UserDto userExist = getMappedDto(userService.getUserByEmail(username));
//
//			if(userExist.getEmail().isBlank()) {
//				throw new ResourceNotFound("User does not exist. Please register.");
//			}
//
//			User logInUser = userService.getUserByEmailAndPassword(username, password);
//			UserDto user = getMappedDto(logInUser);
//
//			if(user.getEmail().isBlank()) {
//				throw new ResourceNotFound("Invalid username or password.");
//			}
//
//			session.setAttribute("loginUser", logInUser);
//			return "redirect:/manage/list";
//
//		}catch(ResourceNotFound e) {
////			model.addAttribute("user",new UserDto());
////			model.addAttribute("message",e.getMessage());
//			return "redirect:/user/login";
//		}
//	}

	@GetMapping("/register")
	public String registerUser(Model model, Principal p) {
		
		if(p != null && !p.getName().isBlank()) {
			return "redirect:/manage/list";
		}
		
		model.addAttribute("user",new UserDto());
		return "user/register";
	}


	@PostMapping("/register")
	public String createUser(@ModelAttribute("user") UserDto user ,Model model, Principal p) {

		if(p != null && !p.getName().isBlank()) {
			return "redirect:/manage/list";
		}
		
		try {
			userService.getUserByEmail(user.getUsername());
			model.addAttribute("message","Email Already exist");
			model.addAttribute("user",user);
			return "account/register?error";

		}catch (ResourceNotFound e){
			
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
			
			User usr = userService.saveUser(getMappeduser(user));
			if(usr != null) {
				return "redirect:/account/login?success";
			}
		}
		return "account/register?error";
	}

//	private UserDto getMappedDto(User user) {
//		UserDto dto = new UserDto();
//		dto.setUsername(user.getEmail());
//		return dto;
//	}

	private User getMappeduser(UserDto user) {
		User usr = new User();
		usr.setUsername(user.getUsername());
		usr.setName(user.getName());
		usr.setPassword(user.getPassword());
		usr.setPhone(user.getPhone());
		usr.setRole("ROLE_USER");
		return usr;
	}

}
