package com.projecttwo.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projecttwo.model.Users;
import com.projecttwo.repository.UserDaoImpl;

@Service("userService")
public class UserService {
	
	UserDaoImpl uD;
	
	@Autowired
	public UserService(UserDaoImpl uDao) {
		this.uD = uDao;
	}
	
	public Integer addUser(Users user) {
		return uD.insertUser(user);
	}
	
	/*@Transactional
	public User getUser(String username) {
		return uD.getUser(username);
	}*/

}
