package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.User;
import com.project.service.UserService;

@RestController("UserController")
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
	
	UserService userService;
	
	public UserController() {
		
	}
	
	@Autowired
	public UserController(UserService uservice) {
		this.userService =uservice;
	}
	
	@RequestMapping(value = "/adduser", method=RequestMethod.POST, headers="Accept=application/json") 
	public void addUser(@RequestBody User user) {
		System.out.println("in addUser, received: "+user);
		userService.addUser(user);
	}
	
	@RequestMapping(value = "/getuser/{username}", method = RequestMethod.GET, headers = "Accept=application/json")
	public User getCountryById(@PathVariable String username) {
		return userService.getUser(username);
	}
	
	
	

}
