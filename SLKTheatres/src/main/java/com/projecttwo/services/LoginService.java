package com.projecttwo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projecttwo.model.Users;
import com.projecttwo.repository.UserDaoImpl;

@Service
public class LoginService {

	UserDaoImpl udao = new UserDaoImpl();
	
	@Autowired
	public LoginService(UserDaoImpl udao) {
		super();
		this.udao = udao;
	}
	
	public boolean loginVerify(String username, String password) {
		
		List<Users> userList = udao.getAllUsers();
		System.out.println("Login Service: getting all users in a list\n" + userList); //for checking
		boolean verify = false;
		
		for(Users user : userList) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				verify = true;
			}
		}
		System.out.println("Login Service: after the for loop verify = " + verify);//for checking
		return verify;
	}
	
	public Users loginByUsername(String username, String password) {
		if(loginVerify(username, password)) {
			System.out.println("Login Service: login by username");//for checking
			return udao.getUserByUsername(username);
		}
		return null;
	}
}
