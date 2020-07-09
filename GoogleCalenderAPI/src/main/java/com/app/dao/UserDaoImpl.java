package com.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.models.UserModel;
import com.app.pojos.User;

@Repository
@Transactional
//Data Access Layer - This will interact with MySQL DB
public class UserDaoImpl implements IUserDao {

	@PersistenceContext
	private EntityManager mgr;

	@Override
	public void register(UserModel u) { // We can pass User's name and email and they get registered.
		User user = new User();
		user.setEmail(u.getEmail());
		user.setName(u.getName());
		mgr.persist(user);
	}

}
