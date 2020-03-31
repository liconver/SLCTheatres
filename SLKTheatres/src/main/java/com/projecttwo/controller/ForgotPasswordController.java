package com.projecttwo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projecttwo.services.ForgotPasswordService;

@Controller
@RequestMapping("/forgotpassword")
@CrossOrigin("*")
public class ForgotPasswordController {
	
	ForgotPasswordService fpwServ;
		
	public ForgotPasswordController() {
	}

	@Autowired
	public ForgotPasswordController(ForgotPasswordService fpwServ) {
		super();
		this.fpwServ = fpwServ;
	}
	
	@PostMapping("/recover.app")
	public @ResponseBody int forgot(@RequestBody String email) {
		System.out.println("in forgotController " + email);
		
		fpwServ.recoverPassword(email);
		return 1;
	}
}
