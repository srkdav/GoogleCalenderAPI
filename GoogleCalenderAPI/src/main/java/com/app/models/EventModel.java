package com.app.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventModel {

	private String name;
	private LocalDate date;
	private LocalTime start;
	private LocalTime end;
	private Integer user_id;
	public EventModel() {
		super();
	}
	public EventModel(String name, LocalDate date, LocalTime start, LocalTime end, Integer user_id) {
		super();
		this.name = name;
		this.date = date;
		this.start = start;
		this.end = end;
		this.user_id = user_id;
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
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "EventModel [name=" + name + ", date=" + date + ", start=" + start + ", end=" + end + ", user_id="
				+ user_id + "]";
	}
		
}
