package com.a14.webinar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.a14.webinar.entity.Event;
import com.a14.webinar.repository.EventRepository;

import jakarta.transaction.Transactional;

@Service
public class EventService {

private EventRepository eventRepo;
	
	public EventService(EventRepository eventRepo) {
		this.eventRepo = eventRepo;
	}
	
	
	public List<Event> getAllEvents(){		
		return eventRepo.findAll();		
	}
	
	@Transactional
	public Event saveEvent(Event event) {
		return eventRepo.save(event);
	}
	
	public Optional<Event> getEventById(Integer id) {
		return eventRepo.findById(id);
	}
	
	@Transactional
	public void deleteEvent(Integer id) {
		eventRepo.deleteById(id);
	}
}
