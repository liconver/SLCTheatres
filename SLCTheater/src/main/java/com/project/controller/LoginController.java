package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.model.User;
import com.project.service.LoginService;
import com.project.service.UserService;

@Controller("LoginController")
@RequestMapping("/login")
@CrossOrigin("*")
public class LoginController {
	
	LoginService loginService;
	
	@Autowired
	public LoginController(LoginService lserv) {
		this.loginService = lserv;
	}
	
	@PostMapping(value="/user.app", produces="application/json", params= {"username","password"})
	public ResponseEntity<User> loginAttempt(String username, String password) {
		return new ResponseEntity<User>(loginService.loginVerify(username,password), HttpStatus.OK);
	}


}
