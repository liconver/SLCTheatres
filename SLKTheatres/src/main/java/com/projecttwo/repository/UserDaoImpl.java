package com.projecttwo.repository;

import java.util.List;

import org.hibernate.Session;
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
	
	public int insertUser(Users user) {
		Session session = null;
		try {
			session = sesFact.getCurrentSession();
			int id = (Integer) session.save(user);
			return id;
		} catch (Exception e) {
			System.out.println("exception while saving user " +e.getMessage());
			return 0;
		} finally {
			session.flush();
		}
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
	
	public Users getUserByEmail(String email) {
		
		uList = sesFact.getCurrentSession().createQuery("from Users where email= '" + email + "'", Users.class).list();
		
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