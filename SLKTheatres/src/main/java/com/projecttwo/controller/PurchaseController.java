package com.projecttwo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.projecttwo.model.Purchase;
import com.projecttwo.model.ShowingSeat;
import com.projecttwo.model.Ticket;
import com.projecttwo.model.TicketPayload;
import com.projecttwo.model.TicketType;
import com.projecttwo.model.Users;
import com.projecttwo.services.PurchaseService;
import com.projecttwo.services.ShowingSeatService;
import com.projecttwo.services.TicketService;
import com.projecttwo.services.TicketTypeService;
import com.projecttwo.services.UserService;

@Controller("PurchaseController")
@RequestMapping("/purchaseapi")
@CrossOrigin(origins="*")
public class PurchaseController {
	
	private PurchaseService pServ;
	private UserService uServ;
	private TicketService tServ;
	private ShowingSeatService ssServ;
	private TicketTypeService ttServ;

	@Autowired
	public PurchaseController(PurchaseService pServ, UserService uServ, TicketService tServ, ShowingSeatService ssServ, TicketTypeService ttServ) {
		super();
		this.pServ = pServ;
		this.uServ = uServ;
		this.tServ = tServ;
		this.ssServ = ssServ;
		this.ttServ = ttServ;
	}
	
	@PostMapping(value="/purchase.app") // for a purchase i need, 1. a NEW id, 2. the price of the purchase, 3, the user id?, 4. seat list data? (seats, type for each)
	public @ResponseBody boolean getSeatsFromShowing( @RequestParam("id") int id, @RequestParam("totalCost") double totalCost, @RequestParam("seatData") String seatData) {
		
		//Grab relevant user with id
		Users user = uServ.getUser(id);
		
		System.out.println(id + " " + totalCost + " " + seatData);
		
		//We store our json seat payload here
		ObjectMapper objectMapper = new ObjectMapper();
		TypeFactory typeFactory = objectMapper.getTypeFactory();
		List<TicketPayload> someClassList = null;
		try {
			someClassList = objectMapper.readValue(seatData, typeFactory.constructCollectionType(List.class, TicketPayload.class));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (TicketPayload current : someClassList) {
			ShowingSeat currSeat = ssServ.getSeatById(current.getId());
			if(currSeat.getStatus() == 1) {
				return false;
			}
		}
		
		Purchase purchase = new Purchase(totalCost, user);
		purchase.setPurchaseId(pServ.sendPurchase(purchase)); 
		System.out.println("The id of the purchase I just made is: " + purchase.getPurchaseId()); //we have our purchase

		for(TicketPayload current: someClassList) {
			
			ShowingSeat currSeat = ssServ.getSeatById(current.getId());
			
			currSeat.setStatus(1);
			
			ssServ.updateSeat(currSeat);
			
			TicketType currTT = ttServ.getTicketType(current.getTypeId());
			
			System.out.println(currTT);
			
			tServ.createTicket(new Ticket(currSeat, currTT, purchase)); //id, seat, tickettype, purchase

		}
		
		return true;
		
	}
	

	
	

}
