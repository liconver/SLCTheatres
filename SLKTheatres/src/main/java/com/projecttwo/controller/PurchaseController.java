package com.projecttwo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projecttwo.model.Purchase;
import com.projecttwo.model.Users;
import com.projecttwo.services.PurchaseService;
import com.projecttwo.services.UserService;

@Controller("PurchaseController")
@RequestMapping("/purchaseapi")
@CrossOrigin(origins="*")
public class PurchaseController {
	
	private PurchaseService pServ;
	private UserService uServ;

	@Autowired
	public PurchaseController(PurchaseService pServ, UserService uServ) {
		super();
		this.pServ = pServ;
		this.uServ = uServ;
	}
	
	@PostMapping(value="/purchase.app") // for a purchase i need, 1. a NEW id, 2. the price of the purchase, 3, the user id?, 4. seat list data? (seats, type for each)
	public @ResponseBody void getSeatsFromShowing( @RequestParam("id") int id, @RequestParam("totalCost") double totalCost, @RequestParam("seatData") String seatData) {
		
		Users user = uServ.getUser(id);
		
		System.out.println(id + " " + totalCost + " " + seatData);
		
		pServ.sendPurchase(new Purchase(30, 9.99, user));
	}

}
