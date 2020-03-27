package com.project.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.User;
import com.project.repository.UserDao;

@Service("userService")
public class UserService {

	UserDao uD;
	
	@Autowired
	public UserService(UserDao uDao) {
		this.uD = uDao;
	}
	
	@Transactional
	public void addUser(User user) {
		uD.addUser(user);
	}
	
	@Transactional
	public User getUser(String username) {
		return uD.getUser(username);
	}
	
	
}
