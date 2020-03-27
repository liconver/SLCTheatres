package com.project.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.User;

@Repository
public class UserDao {
	
	private SessionFactory sF;

	@Autowired
	public UserDao(SessionFactory sessFact) {
		super();
		this.sF = sessFact;
	}
	
	
	public User addUser(User user) {
		this.sF.getCurrentSession().persist(user);
		return user;
	}
	
	public Map<String, User> getAllUsers() {
		Session session = this.sF.getCurrentSession();
		List<User> userList = session.createQuery("from Users").list();
		Map<String, User> userMap = new HashMap<String, User>();
		for (User user: userList) {
			userMap.put(user.getUsername(), user);
			}
		return userMap;
	}
	
	public User getUser(String username) {
		Session session = this.sF.getCurrentSession();
		User user = (User) session.load(User.class, username);
		return user;
	}
	
	

}
