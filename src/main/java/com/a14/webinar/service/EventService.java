package com.a14.webinar.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.a14.webinar.entity.Event;
import com.a14.webinar.error.ResourceNotFound;
import com.a14.webinar.repository.EventRepository;

import jakarta.transaction.Transactional;

@Service
public class EventService {

	private EventRepository eventRepo;
	
	LocalDate currentDate = LocalDate.now();
	
	public EventService(EventRepository eventRepo) {
		this.eventRepo = eventRepo;
	}


	public List<Event> getAllEvents(){
		return eventRepo.findAll();
	}
	
	public List<Event> getActiveEvents(){
		return eventRepo.findByOccursOnGreaterThanAndPublishedAndApprovedOrderByOccursOnDesc(currentDate.toString(), 1,1 );
	}
	
	
	
	public List<Event> getUserEvents(int id){		
		return eventRepo.findByCreatedByOrderByIdDesc(id).stream().toList();
	}
	
	

	@Transactional
	public Event saveEvent(Event event) {
		return eventRepo.save(event);
	}

	public Event getEventById(Integer id) {
		return eventRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Event not found."));
	}

	@Transactional
	public void deleteEvent(Integer id) {
		eventRepo.findById(id).ifPresentOrElse(eventRepo::delete, () -> new ResourceNotFound("Event not found."));
	}
}
