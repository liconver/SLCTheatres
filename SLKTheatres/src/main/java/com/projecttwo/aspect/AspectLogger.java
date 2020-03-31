package com.projecttwo.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("AspectLogger")
@Aspect
public class AspectLogger {
	
	public final static Logger logger = Logger.getLogger(AspectLogger.class);
	
	@Before("execution(* com.projecttwo.controller.LoginController.*(..))")
	public void logLoginControllerEntry(JoinPoint jp) {
		logger.info("Entering " + jp.getSignature() + "Login Controller");
	}
	
	@After("execution(* com.projecttwo.controller.LoginController.*(..))")
	public void logLoginControllerExit(JoinPoint jp) {
		logger.info("Exiting " + jp.getSignature() + "Login Controller");
	}
	
	@Before("execution(* com.projecttwo.controller.UserController.*(..))")
	public void logUserControllerEntry(JoinPoint jp) {
		logger.info("Entering " + jp.getSignature() + "User Controller");
	}
	
	@After("execution(* com.projecttwo.controller.UserController.*(..))")
	public void logUserControllerExit(JoinPoint jp) {
		logger.info("Exiting " + jp.getSignature() + "User Controller");
	}
	
	@Before("execution(* com.projecttwo.controller.PastPurchasesController.*(..))")
	public void logPPControllerEntry(JoinPoint jp) {
		logger.info("Entering " + jp.getSignature() + "Past Purchases Controller");
	}
	
	@After("execution(* com.projecttwo.controller.PastPurchasesController.*(..))")
	public void logPPControllerExit(JoinPoint jp) {
		logger.info("Exiting " + jp.getSignature() + "Past Purchases Controller");
	}
	
	@Before("execution(* com.projecttwo.controller.ForgotPasswordController.*(..))")
	public void logFPassControllerEntry(JoinPoint jp) {
		logger.info("Entering " + jp.getSignature() + "Forgot Password Controller");
	}
	
	@After("execution(* com.projecttwo.controller.ForgotPasswordController.*(..))")
	public void logFPassControllerExit(JoinPoint jp) {
		logger.info("Exiting " + jp.getSignature() + "Forgot Password Controller");
	}
	
	@Before("execution(* com.projecttwo.repository.UserDaoImpl.*(..))")
	public void logUserDaoEntry(JoinPoint jp) {
		logger.info("Entering " + jp.getSignature() + "User Dao");
	}
	
	@After("execution(* com.projecttwo.repository.UserDaoImpl.*(..))")
	public void logUserDaoExit(JoinPoint jp) {
		logger.info("Exiting " + jp.getSignature() + "User Dao");
	}
	
	@Before("execution(* com.projecttwo.repository.TicketDaoImpl.*(..))")
	public void logTicketDaoEntry(JoinPoint jp) {
		logger.info("Entering " + jp.getSignature() + "Ticket Dao");
	}
	
	@After("execution(* com.projecttwo.repository.TicketDaoImpl.*(..))")
	public void logTicketDaoExit(JoinPoint jp) {
		logger.info("Exiting " + jp.getSignature() + "Ticket Dao");
	}
	
	@Before("execution(* com.projecttwo.repository.PurchaseDaoImpl.*(..))")
	public void logPurchaseDaoEntry(JoinPoint jp) {
		logger.info("Entering " + jp.getSignature() + "Purchase Dao");
	}
	
	@After("execution(* com.projecttwo.repository.PurchaseDaoImpl.*(..))")
	public void logPurchaseDaoExit(JoinPoint jp) {
		logger.info("Exiting " + jp.getSignature() + "Purchase Dao");
	}
	
	@Before("execution(* com.projecttwo.repository.ShowingSeatDaoImpl.*(..))")
	public void logSeatDaoEntry(JoinPoint jp) {
		logger.info("Entering " + jp.getSignature() + "Seat Dao");
	}
	
	@After("execution(* com.projecttwo.repository.ShowingSeatDaoImpl.*(..))")
	public void logSeatDaoExit(JoinPoint jp) {
		logger.info("Exiting " + jp.getSignature() + "Seat Dao");
	}
	
	
	@After("execution(* com.projecttwo.services.EmailService.sendMail(..))")
	public void logEmailSend(JoinPoint jp) {
		logger.info("Emailing " + jp.getSignature() + "!!! :)");
	}
	
}
