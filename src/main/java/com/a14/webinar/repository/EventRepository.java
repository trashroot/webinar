package com.a14.webinar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.a14.webinar.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event,Integer>{

}
