package com.projecttwo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projecttwo.services.ForgotPasswordService;

@Controller
@RequestMapping("/forgotpassword")
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
	public @ResponseBody void forgot(@RequestParam("email") String email) {
		System.out.println("in forgotController " + email);
		
		fpwServ.recoverPassword(email);
		
	}
	
}
