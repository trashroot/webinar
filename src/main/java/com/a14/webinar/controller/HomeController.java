package com.a14.webinar.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

//import com.a14.webinar.dto.EventDto;
import com.a14.webinar.entity.Event;
import com.a14.webinar.service.EventService;


//Register reminder
//Share the event
//Comments
//Registration Only

@Controller
public class HomeController {

	private EventService eventService;

	public HomeController(EventService eventService) {
		super();
		this.eventService = eventService;
	}

	@GetMapping("/")
	public ModelAndView index() {
		List<Event> data = eventService.getAllEvents();
		return new ModelAndView("main","events",data);
	}

	@GetMapping("/webinar")
	public ModelAndView home() {
		List<Event> data = eventService.getAllEvents();
		return new ModelAndView("main","events",data);
	}
	
	@GetMapping("/details/{id}")
	public ModelAndView details(@PathVariable("id") int id) {
		Event data = eventService.getEventById(id);
		return new ModelAndView("edit","event",data);
	}

}
