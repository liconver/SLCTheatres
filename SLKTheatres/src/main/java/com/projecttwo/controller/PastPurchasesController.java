package com.projecttwo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projecttwo.model.Ticket;
import com.projecttwo.services.PastPService;

@RestController("PastPurchaseController")
@RequestMapping("/ppapi")
@CrossOrigin("*")
public class PastPurchasesController {
		
	PastPService pPServ;

	public PastPurchasesController() {
		
	}
	
	@Autowired 
	public PastPurchasesController(PastPService pPServ) {
		super();
		this.pPServ = pPServ;
	}
	
//	@GetMapping(value = "/getallpurchases.app")
//	public List<Ticket> getPurchases() { 
//		System.out.println("in get all purchases "); 
//		List<Ticket> allTickets = pPServ.getAllPurchases(); 
//		System.out.println(allTickets);
//		return allTickets;
//	}
	
	@GetMapping(value = "/getallpurchase/{userId}")
	public List<Ticket> getPurchases(@PathVariable("userId") int userId) { 
		System.out.println("in getpurchases controller for userid: "+userId); 
		return pPServ.getAllByUser(userId); 
	}
}











