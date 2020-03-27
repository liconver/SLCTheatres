package com.project.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.User;
import com.project.repository.UserDao;

@Service("loginService")
public class LoginService {
	
	UserDao uD;
	
	@Autowired
	public LoginService(UserDao uDao) {
		this.uD = uDao;
	}
	
	@Transactional
	public User loginVerify(String username, String password) {
		Map<String, User> userMap = uD.getAllUsers();
		if (userMap.containsKey(username)) {
			if (userMap.get(username).getPassword().equals(password)) {
				return userMap.get(username);
			} else {
				return new User("Invalid");
			}
		} else {
			return new User("Invalid");
		}
	}

	
	
}
