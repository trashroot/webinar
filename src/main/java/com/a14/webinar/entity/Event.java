package com.a14.webinar.entity;


/*import java.sql.Time;
import java.sql.Date;*/
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String title;

	@Column(columnDefinition = "TEXT")
	private String description;

	private String image;

	private String occursOn;

	private String startAt;

	private String endAt;

	private String venue;

	private String city;

	private String country;

	private String organizer;

//	private Boolean invite_only;

	private Integer createdBy;

	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", desc=" + description + ", image=" + image + ", occurs_on="
				+ occursOn + ", start_at=" + startAt + ", end_at=" + endAt + ", venue=" + venue + ", city=" + city
				+ ", country=" + country + ", organizer=" + organizer + ", created_by=" + createdBy + "]";
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer created_by) {
		this.createdBy = created_by;
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
		this.occursOn = occurs_on;
		this.startAt = start_at;
		this.endAt = end_at;
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

	public String getOccursOn() {
		return occursOn;
	}

	public void setOccursOn(String occurs_on) {
		this.occursOn = occurs_on;
	}

	public String getStartAt() {
		return startAt;
	}

	public void setStartAt(String start_at) {
		this.startAt = start_at;
	}

	public String getEndAt() {
		return endAt;
	}

	public void setEndAt(String end_at) {
		this.endAt = end_at;
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
