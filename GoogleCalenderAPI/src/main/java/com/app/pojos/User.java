package com.app.pojos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

	@Id // Every ID is unique & automatically generated.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;
	private String name;
	private String email;
	@OneToMany(mappedBy = "user") // One User can have many events. @OneToMany comes at User side.
	private List<Event> events;// MappedBy = "user" as the the field on Event side is refered as "user"

	public User() {
		super();
	}

	public User(Integer user_id, String name, String email, List<Event> events) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.events = events;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
//	@Override
//	public String toString() {
//		return "User [user_id=" + user_id + ", name=" + name + ", email=" + email + ", events=" + events + "]";
//	}

}
