package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.app.models.EventModel;
import com.app.pojos.Event;
import com.app.pojos.User;

@Repository
@Transactional
//Data Access Layer - This will interact with MySQL DB
public class EventsDaoImpl implements IEventsDao {

	@PersistenceContext
	private EntityManager mgr;


	@Override 
	public void addEvent(List<EventModel> list) {
		for (EventModel e : list) {
			Integer user_id = e.getUser_id(); 
			User user_existing = mgr.find(User.class, user_id);//Get the User reference
			String jpql = "Insert into Event (date,end,name,start,user_id)values(?,?,?,?,?)";
			mgr.createNativeQuery(jpql).setParameter(1, e.getDate()).setParameter(2, e.getEnd())
					.setParameter(3, e.getName()).setParameter(4, e.getStart()).setParameter(5, user_existing).executeUpdate();
		}
	}

	@Override
	public List<Event> findEventsByUser(Integer user_id) {
		User user_existing = mgr.find(User.class, user_id); // Get the user reference.
		String jpql = "SELECT e FROM Event e where e.user=:user_existing ";// Since User is a FK in Events,there is a
																			// where clause to find all the events as
																			// per this user.
		List<Event> list = mgr.createQuery(jpql, Event.class).setParameter("user_existing", user_existing).getResultList();

		return list;
	}

}
