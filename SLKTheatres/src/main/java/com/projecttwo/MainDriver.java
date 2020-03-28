package com.projecttwo;

import java.sql.Timestamp;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.projecttwo.model.Movie;
import com.projecttwo.model.Purchase;
import com.projecttwo.model.Showing;
import com.projecttwo.model.ShowingSeat;
import com.projecttwo.model.TicketType;
import com.projecttwo.model.Users;
import com.projecttwo.repository.MovieDaoImpl;
import com.projecttwo.repository.PurchaseDaoImpl;
import com.projecttwo.repository.ShowingDaoImpl;
import com.projecttwo.repository.ShowingSeatDaoImpl;
import com.projecttwo.repository.TicketDaoImpl;
import com.projecttwo.repository.TicketTypeDaoImpl;
import com.projecttwo.repository.UserDaoImpl;

public class MainDriver {
	
	public static ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	public static MovieDaoImpl movieDao = appContext.getBean("movieDao", MovieDaoImpl.class);
	public static PurchaseDaoImpl purchaseDao = appContext.getBean("purchaseDao", PurchaseDaoImpl.class);
	public static ShowingSeatDaoImpl seatDao = appContext.getBean("seatDao", ShowingSeatDaoImpl.class);
	public static ShowingDaoImpl showingDao = appContext.getBean("showingDao", ShowingDaoImpl.class);
	public static UserDaoImpl userDao = appContext.getBean("userDao", UserDaoImpl.class);
	public static TicketTypeDaoImpl ticketTypeDao = appContext.getBean("ticketTypeDao", TicketTypeDaoImpl.class);
	public static TicketDaoImpl ticketDao = appContext.getBean("ticketDao", TicketDaoImpl.class);
	
//	public static MovieDaoImpl movieDao;
//	public static PurchaseDaoImpl purchaseDao;
//	public static ShowingSeatDaoImpl seatDao;
//	public static ShowingDaoImpl showingDao;
//	public static UserDaoImpl userDao;
//	public static TicketTypeDaoImpl ticketTypeDao;
//	public static TicketDaoImpl ticketDao;
	
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
		
//		System.out.println("Selecting by Name");
//		System.out.println(seatDao.selectByName("A1"));
		
//		ShowingSeat showingSeat = new ShowingSeat("A3", 2);
//		seatDao.update(showingSeat);
//		System.out.println(userDao.getUserByUsername("cjf"));
		
		
		
		System.out.println(purchaseDao.selectAll());
		System.out.println(purchaseDao.selectAllByUser(userDao.getUserByUsername("liam").getUserId()));
		
	}
	
	public static void insertInitialValues() {
		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		
		//Movie
		Movie movie1 = new Movie("Tyler Perry: Black Don't Crack", "Another stupid TP movie for yall to think is funny.", 103, "");
		Movie movie2 = new Movie("Naruto Live Action", "Better than AirBender Live Action but still bad", 86, "");
		Movie movie3 = new Movie("Django: Flees the South", "Django kills more white people while running to the North", 124, "");
		
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
		
		//User
		Users user1 = new Users("cjf", "7777", "Christian", "Falzone", "c@gmail.com");
		userDao.insertUser(user1); 			
		
		
		Users user2 = new Users("serg", "berg", "Sergio", "Gamboa", "s@yahoo.com");
		userDao.insertUser(user2);	
		

		Users user3 = new Users("liam", "taken", "Liam", "Converse", "l@revature.com");
		userDao.insertUser(user3);
		
		//Purchase
		Purchase purchase1 = new Purchase(12.99, user1);
		user1.getpList().add(purchase1);
		Purchase purchase2 = new Purchase(8.99, user1);
		user1.getpList().add(purchase2);
		Purchase purchase3 = new Purchase(12.99, user1);
		user1.getpList().add(purchase3);
		Purchase purchase4 = new Purchase(6.99, user3);
		user3.getpList().add(purchase4);
		Purchase purchase5 = new Purchase(12.99, user2);
		user2.getpList().add(purchase5);
		Purchase purchase6 = new Purchase(8.99, user2);
		user2.getpList().add(purchase6);
		Purchase purchase7 = new Purchase(12.99, user2);
		user2.getpList().add(purchase7);
		Purchase purchase8 = new Purchase(6.99, user3);
		user3.getpList().add(purchase8);
				
		//Ticket
//		Ticket ticket1 = new Ticket();
		
		//TicketType
		TicketType ticketType1 = new TicketType("Adult", 12.99);
		TicketType ticketType2 = new TicketType("Senior", 8.99);
		TicketType ticketType3 = new TicketType("Child", 6.99);
		
		
///////////Inserts///////////////
		movieDao.insert(movie1);	movieDao.insert(movie2);	movieDao.insert(movie3);
		
		showingDao.insert(showing1);	showingDao.insert(showing2);	showingDao.insert(showing3);
		
		seatDao.insert(seat1);	seatDao.insert(seat2);	seatDao.insert(seat3);	seatDao.insert(seat4);
		seatDao.insert(seat5);	seatDao.insert(seat6);	seatDao.insert(seat7);	seatDao.insert(seat8);
		seatDao.insert(seat9);	seatDao.insert(seat10);
		
		purchaseDao.insert(purchase1);			purchaseDao.insert(purchase2);
		purchaseDao.insert(purchase3);			purchaseDao.insert(purchase4);
		purchaseDao.insert(purchase5);			purchaseDao.insert(purchase6);
		purchaseDao.insert(purchase7);			purchaseDao.insert(purchase8);
		
		ticketTypeDao.insert(ticketType1);
		ticketTypeDao.insert(ticketType2);
		ticketTypeDao.insert(ticketType3);
		
		
	}
}