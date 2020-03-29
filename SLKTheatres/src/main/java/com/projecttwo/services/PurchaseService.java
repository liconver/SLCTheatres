package com.projecttwo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projecttwo.model.Purchase;
import com.projecttwo.model.Ticket;
import com.projecttwo.repository.PurchaseDaoImpl;
import com.projecttwo.repository.TicketDaoImpl;

@Service
public class PurchaseService {
	
	@Autowired
	public PurchaseService(PurchaseDaoImpl pdao, TicketDaoImpl tdao) {
		super();
		this.pdao = pdao;
		this.tdao = tdao;
	}

	PurchaseDaoImpl pdao = new PurchaseDaoImpl();
	TicketDaoImpl tdao = new TicketDaoImpl();
	
	public int sendPurchase(Purchase purchase) {
		purchase.setPurchaseId(pdao.insert(purchase));
		return purchase.getPurchaseId();
	}
	
	public void sendTickets(Ticket ticket) {
		tdao.insert(ticket);
	}
	

}
