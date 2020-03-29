package com.projecttwo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projecttwo.model.Users;
import com.projecttwo.services.LoginService;
import com.projecttwo.services.UserService;

@RestController("UserController")
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {

	UserService userService;
	LoginService loginService;

	public UserController() {

	}

	@Autowired
	public UserController(UserService uservice, LoginService lservice) {
		this.userService = uservice;
		this.loginService = lservice;
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST, headers = "Accept=application/json")
	public int addUser(@RequestBody Users user) {
		System.out.println("in addUser, received: " + user);
		return userService.addUser(user);
	}

	@PostMapping(value = "/loginuser")
	public ResponseEntity<Integer> loginUser(@RequestBody Users user) {
		int status;
		HttpHeaders httpHeader = null;

		// Authenticate User.
		status = loginService.loginVerify(user.getUsername(), user.getPassword());

		/*
		 * If User is authenticated then Do Authorization Task.
		 */
		if (status > 0) {
			/*
			 * Generate token.
			 */
			// String tokenData[] = generateToken.createJWT(adminDetail.getEmailId(),
			// "JavaTpoint", "JWT Token",
			// adminDetail.getRole(), 43200000);

			// get Token.
//		            String token = tokenData[0];  
//		              
//		            System.out.println("Authorization :: " + token);  
//		  
//		            // Create the Header Object  
//		            httpHeader = new HttpHeaders();  
//		  
//		            // Add token to the Header.  
//		            httpHeader.add("Authorization", token);  
//		  
//		            // Check if token is already exist.  
//		            long isUserEmailExists = tokenService.getTokenDetail(adminDetail.getEmailId());  
//		              
//		            /* 
//		             * If token exist then update Token else create and insert the token. 
//		             */  
//		            if (isUserEmailExists > 0)   
//		            {  
//		                tokenService.updateToken(adminDetail.getEmailId(), token, tokenData[1]);  
//		            }   
//		            else   
//		            {  
//		                tokenService.saveUserEmail(adminDetail.getEmailId(), status);  
//		                tokenService.updateToken(adminDetail.getEmailId(), token, tokenData[1]);  
//		            }  
//		  
//		            return new ResponseEntity<Integer>(status, httpHeader, HttpStatus.OK);  
			return new ResponseEntity<Integer>(status, HttpStatus.OK);
		}

		// if not authenticated return status what we get.
		else {
//		            return new ResponseEntity<Integer>(status, httpHeader, HttpStatus.OK);  
			return new ResponseEntity<Integer>(status, HttpStatus.OK);
		}

	}
}
