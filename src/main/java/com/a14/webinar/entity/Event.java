package com.a14.webinar.entity;


/*import java.sql.Time;
import java.sql.Date;*/

import jakarta.persistence.*;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	private String image;
	
	private String occurs_on;
	
	private String start_at;
	
	private String end_at;
	
	private String venue;
	
	private String city;
	
	private String country;
	
	private String organizer;
	
//	private Boolean invite_only;
	
	private String created_by;
	
	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", desc=" + description + ", image=" + image + ", occurs_on="
				+ occurs_on + ", start_at=" + start_at + ", end_at=" + end_at + ", venue=" + venue + ", city=" + city
				+ ", country=" + country + ", organizer=" + organizer + ", created_by=" + created_by + "]";
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public Event() {
		
	}

	public Event(int id, String title, String desc, String image, String occurs_on, String start_at, String end_at,
			String venue, String city, String country, String organizer, Boolean invite_only) {
		super();
		this.id = id;
		this.title = title;
		this.description = desc;
		this.image = image;
		this.occurs_on = occurs_on;
		this.start_at = start_at;
		this.end_at = end_at;
		this.venue = venue;
		this.city = city;
		this.country = country;
		this.organizer = organizer;
//		this.invite_only = invite_only;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return description;
	}

	public void setDesc(String desc) {
		this.description = desc;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getOccurs_on() {
		return occurs_on;
	}

	public void setOccurs_on(String occurs_on) {
		this.occurs_on = occurs_on;
	}

	public String getStart_at() {
		return start_at;
	}

	public void setStart_at(String start_at) {
		this.start_at = start_at;
	}

	public String getEnd_at() {
		return end_at;
	}

	public void setEnd_at(String end_at) {
		this.end_at = end_at;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

//	public Boolean getInvite_only() {
//		return invite_only;
//	}
//
//	public void setInvite_only(Boolean invite_only) {
//		this.invite_only = invite_only;
//	}

	
	
}
