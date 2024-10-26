package com.a14.webinar.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.a14.webinar.dto.EventDto;
import com.a14.webinar.entity.Event;
import com.a14.webinar.entity.User;
import com.a14.webinar.error.ResourceNotFound;
import com.a14.webinar.service.EventService;
import com.a14.webinar.service.UserService;

@Controller
@RequestMapping("/manage")
public class ManageController {

	private EventService eventService;
	private UserService userService;

	public ManageController(EventService eventService, UserService userService) {
		this.eventService = eventService;
		this.userService = userService;
	}

	@GetMapping("/list")
	public ModelAndView index(Principal p) {
		
		if(p != null && p.getName().isBlank()) {
			throw new ResourceNotFound("Event not found.");
		}
		
		User u = userService.getUserByEmail(p.getName());
		
		if(u == null) {
			throw new ResourceNotFound("User does not exist.");
		}
		
		List<Event> data = eventService.getUserEvents(u.getId());
		return new ModelAndView("manage/list","events",data);
	}

	@GetMapping("/addWebinar")
	public String addWebinar(Model model) {
		EventDto event = new EventDto();
		model.addAttribute("event",event);
		return "add";
	}

	@PostMapping("/add")
	public String newWebinar(@ModelAttribute("event") Event event) {
		eventService.saveEvent(event);
		return "redirect:/webinar";
	}

	@GetMapping("/edit/{id}")
	public String editWebinar(@PathVariable("id") Integer postid, Model model) {
		try {
			Event event = eventService.getEventById(postid);
			model.addAttribute("event",event);

		}catch(ResourceNotFound e) {
			model.addAttribute("event",new Event());
			model.addAttribute("message",e.getMessage());

		}
		return "edit";
	}

	@PostMapping("/saveEdit")
	public String editWebinar(@ModelAttribute("event") Event event) {

		eventService.saveEvent(event);
		return "redirect:/manage/list";
	}

	@GetMapping("/delete/{id}")
	public String deleteWebinar(@PathVariable("id") Integer postid) {
		eventService.deleteEvent(postid);
		return "redirect:/manage/list";
	}
}
