package com.projecttwo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.projecttwo.model.Users;
import com.projecttwo.repository.UserDaoImpl;

@Service
public class ForgotPasswordService {

	UserDaoImpl userDao = new UserDaoImpl();
	
	@Autowired
	public ForgotPasswordService(UserDaoImpl userDao) {
		super();
		this.userDao = userDao;
	}
	
	public boolean emailVerify(String email) {

		List<Users> userList = userDao.getAllUsers();
		System.out.println("ForgotPassword Service: getting all users in a list\n" + userList); // for checking
		boolean verify = false;

		for (Users user : userList) {
			if (user.getEmail().equalsIgnoreCase(email)) {
				verify = true;
			}
		}
		System.out.println("ForgotPassword Service: after the for loop verify = " + verify);// for checking
		return verify;
	}

	public void recoverPassword(String email) {
		Users user = new Users();
		if (emailVerify(email)) {
			System.out.println("ForgotPassword Service: recovering pw");// for checking
			user = userDao.getUserByEmail(email);
		}
		if(user == null) {
			System.out.println("user is null");
			/////////////////////////////////
		}else {
			System.out.println("user is " + user);
			
			ApplicationContext context = new FileSystemXmlApplicationContext("classpath:/applicationContext.xml");
          
	        //Get the mailer instance
	        EmailService mailer = (EmailService) context.getBean("emailService");
	  
	        //Send a composed mail
	        String receiver = "slc.theatres@gmail.com";  //user.getEmail();//
			String subject = "Recover Password - SLC Theatres";
			String body = "Your account password is: " + user.getPassword() + ". Thank you for being a valued customer.";
	        mailer.sendMail(receiver, subject, body);			
		}
	}
}










