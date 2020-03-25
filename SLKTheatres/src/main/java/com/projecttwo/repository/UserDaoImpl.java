package com.projecttwo.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projecttwo.model.Users;

@Transactional
@Repository("userDao")
public class UserDaoImpl{

	private SessionFactory sesFact;
	List<Users> uList;
	
	public UserDaoImpl() {
	}
	
	@Autowired
	public UserDaoImpl(SessionFactory sesFact) {
		super();
		this.sesFact = sesFact;
	}
	
	public void insertUser(Users user) {
		sesFact.getCurrentSession().save(user);
	}
	
	public Users getUserById(int userId) {
		return sesFact.getCurrentSession().get(Users.class, userId);
	}
	
	public Users getUserByUsername(String username) {
		
		uList = sesFact.getCurrentSession().createQuery("from Users where username= '" + username + "'", Users.class).list();
		
		if (uList.size() == 0) {
			System.out.println("No user");
			return null;
		}
		return uList.get(0);
	}
	
	public List<Users> getAllUsers() {
		return sesFact.getCurrentSession().createQuery("from Users", Users.class).list();	
	}

}