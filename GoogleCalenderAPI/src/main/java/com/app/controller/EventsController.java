package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dao.IEventsDao;
import com.app.models.EventModel;
import com.app.pojos.Event;

@Controller
@RequestMapping("/event")
@CrossOrigin
public class EventsController {

	@Autowired
	private IEventsDao dao;

	@GetMapping("/GetEventsByUser/{user_id}") // User ID is sent as Path Variable and only the User's Events are
												// displayed.
	public ResponseEntity<List<EventModel>> findEventsByUser(@PathVariable Integer user_id) {
		System.out.println(user_id);
		List<Event> list = dao.findEventsByUser(user_id);
		List<EventModel> list_model = new ArrayList<>();
		for (Event e : list) {
			EventModel newModel = new EventModel();
			newModel.setDate(e.getDate());
			newModel.setEnd(e.getEnd());
			newModel.setName(e.getName());
			newModel.setStart(e.getStart());
			newModel.setUser_id(e.getUser().getUser_id());
			list_model.add(newModel);
		}
		return new ResponseEntity<List<EventModel>>(list_model, HttpStatus.OK);
	}

	@PostMapping("/AddEvent") // This will add the events as entered by User.
	public ResponseEntity<String> addEvent(@RequestBody List<EventModel> e) {
		dao.addEvent(e);
		return new ResponseEntity<String>("New Event created!", HttpStatus.OK);

	}

}
