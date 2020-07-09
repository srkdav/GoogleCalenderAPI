package com.app.pojos;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Event")
public class Event {

	@Id // Event ID gets automatically generated.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer event_id;
	private String name;
	private LocalDate date;
	private LocalTime start;
	private LocalTime end;

	@ManyToOne // One user can have Many Events, @ManyToOne comes as the many side.
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public Event() {
		super();
	}

	public Event(Integer event_id, String name, LocalDate date, LocalTime start, LocalTime end, User user) {
		super();
		this.event_id = event_id;
		this.name = name;
		this.date = date;
		this.start = start;
		this.end = end;
		this.user = user;
	}

	public Integer getEvent_id() {
		return event_id;
	}

	public void setEvent_id(Integer event_id) {
		this.event_id = event_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getStart() {
		return start;
	}

	public void setStart(LocalTime start) {
		this.start = start;
	}

	public LocalTime getEnd() {
		return end;
	}

	public void setEnd(LocalTime end) {
		this.end = end;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
