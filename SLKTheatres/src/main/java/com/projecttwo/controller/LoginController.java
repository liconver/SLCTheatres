package com.projecttwo.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projecttwo.model.Users;
import com.projecttwo.services.LoginService;

@Controller("LoginController")
@RequestMapping("/api")
public class LoginController {

	private LoginService loginServ;
	private SessionFactory sesFact;
	
	public LoginController() {
	}

	@Autowired
	public LoginController(LoginService loginServ) {
		super();
		this.loginServ = loginServ;
	}
	
	
	@PostMapping(value= "/login.app")
	public @ResponseBody String login(@RequestParam("username") String username, @RequestParam("password") String password){
		
		Users user = loginServ.loginByUsername(username, password);		
		if(user == null) {
			return "wronglogin.html";
		}else {
			return "home.html";
		}
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
}
