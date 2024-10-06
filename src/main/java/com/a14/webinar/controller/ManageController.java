package com.a14.webinar.controller;

import java.util.List;
import java.util.Optional;

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
import com.a14.webinar.service.EventService;

@Controller
@RequestMapping("/manage")
public class ManageController {
	
	private EventService eventService;
	
	public ManageController(EventService eventService) {
		this.eventService = eventService;
	}
	
	@GetMapping("/list")
	public ModelAndView index() {
		List<Event> data = eventService.getAllEvents();
		
		System.out.println(data.toString()+"==========");
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
		Optional<Event> event1 = eventService.getEventById(postid);
//		EventDto event = new EventDto();
		Event e = event1.get();
		model.addAttribute("event",e);
		return "edit";
	}
	
	@PostMapping("/saveEdit")
	public String editWebinar(@ModelAttribute("event") Event event, @PathVariable int id) {
		
		eventService.saveEvent(event);
		return "redirect:/manage/list";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteWebinar(@PathVariable("id") Integer postid) {
		eventService.deleteEvent(postid);
		return "redirect:/manage/list";
	}
}
