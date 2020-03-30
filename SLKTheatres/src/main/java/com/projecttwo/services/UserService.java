package com.projecttwo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
//	@Transactional
	public Users getUser(int id) {
		return uD.getUserById(id);
	}
	
	public void getAllUsers() {
		System.out.println("in get all users service");
		uD.getAllUsers();
	}
	
	public Users getUserByUsername(String username) {
		return uD.getUserByUsername(username);
		
	}

}
