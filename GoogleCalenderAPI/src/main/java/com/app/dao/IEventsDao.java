package com.app.dao;

import java.util.List;

import com.app.models.EventModel;
import com.app.pojos.Event;

public interface IEventsDao {

	void addEvent(List<EventModel> list);
	List<Event> findEventsByUser(Integer user_id);
	
}
