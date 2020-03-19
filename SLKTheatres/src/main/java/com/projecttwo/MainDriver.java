package com.projecttwo;

import java.sql.Timestamp;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.projecttwo.dao.MovieDaoImpl;
import com.projecttwo.dao.PurchaseDaoImpl;
import com.projecttwo.dao.ShowingDaoImpl;
import com.projecttwo.dao.ShowingSeatDaoImpl;
import com.projecttwo.model.Movie;
import com.projecttwo.model.Purchase;
import com.projecttwo.model.Showing;
import com.projecttwo.model.ShowingSeat;

public class MainDriver {
	
	public static ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	public static MovieDaoImpl movieDao = appContext.getBean("movieDao", MovieDaoImpl.class);
	public static PurchaseDaoImpl purchaseDao = appContext.getBean("purchaseDao", PurchaseDaoImpl.class);
	public static ShowingSeatDaoImpl seatDao = appContext.getBean("seatDao", ShowingSeatDaoImpl.class);
	public static ShowingDaoImpl showingDao = appContext.getBean("showingDao", ShowingDaoImpl.class);
	
	public final static Logger logger = Logger.getLogger(MainDriver.class);
	
	public static void main(String[] args) {
		
		logger.setLevel(Level.FATAL);
		
		insertInitialValues();
		
//		System.err.println("Selecting by ID");
//		System.err.println(movieDao.selectById(1));
//		System.err.println(purchaseDao.selectById(19));
//		System.err.println(seatDao.selectById(10));
//		System.err.println(showingDao.selectById(5));
//		
//		System.err.println("Selecting All");
//		System.err.println(movieDao.selectAll());
//		System.err.println(purchaseDao.selectAll());
//		System.err.println(seatDao.selectAll());
//		System.err.println(showingDao.selectAll());
		
		System.out.println("Selecting by Name");
		System.out.println(seatDao.selectByName("A1"));
		
//		ShowingSeat showingSeat = new ShowingSeat("A3", 2);
//		seatDao.update(showingSeat);
		
	}
	
	public static void insertInitialValues() {
		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		
		//Movie
		Movie movie1 = new Movie("Tyler Perry: Black Don't Crack", "Another stupid TP movie for yall to think is funny.", 103);
		Movie movie2 = new Movie("Naruto Live Action", "Better than AirBender Live Action but still bad", 86);
		Movie movie3 = new Movie("Django: Flees the South", "Django kills more white people while running to the North", 124);
		
		//Showing
		Showing showing1 = new Showing(timeStamp);
		Showing showing2 = new Showing(timeStamp);
		Showing showing3 = new Showing(timeStamp);
		
		//Seats
		ShowingSeat seat1 = new ShowingSeat("A1", 0);
		ShowingSeat seat2 = new ShowingSeat("B2", 0);
		ShowingSeat seat3 = new ShowingSeat("C3", 0);
		ShowingSeat seat4 = new ShowingSeat("D4", 1);
		ShowingSeat seat5 = new ShowingSeat("E5", 1);
		ShowingSeat seat6 = new ShowingSeat("F6", 1);
		ShowingSeat seat7 = new ShowingSeat("G7", 0);
		ShowingSeat seat8 = new ShowingSeat("H8", 2);
		ShowingSeat seat9 = new ShowingSeat("I9", 2);
		ShowingSeat seat10 = new ShowingSeat("A2", 0);
		
		//Purchase
		Purchase purchase1 = new Purchase(12.99);
		Purchase purchase2 = new Purchase(8.99);
		Purchase purchase3 = new Purchase(12.99);
		Purchase purchase4 = new Purchase(6.99);
		
		
		//User
		
		//Inserts
		movieDao.insert(movie1);	movieDao.insert(movie2);	movieDao.insert(movie3);
		
		showingDao.insert(showing1);	showingDao.insert(showing2);	showingDao.insert(showing3);
		
		seatDao.insert(seat1);	seatDao.insert(seat2);	seatDao.insert(seat3);	seatDao.insert(seat4);
		seatDao.insert(seat5);	seatDao.insert(seat6);	seatDao.insert(seat7);	seatDao.insert(seat8);
		seatDao.insert(seat9);	seatDao.insert(seat10);
		
		purchaseDao.insert(purchase1);			purchaseDao.insert(purchase2);
		purchaseDao.insert(purchase3);			purchaseDao.insert(purchase4);
		
	}
}
