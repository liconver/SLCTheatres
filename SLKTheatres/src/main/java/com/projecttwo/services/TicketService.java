package com.projecttwo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projecttwo.model.Ticket;
import com.projecttwo.repository.TicketDaoImpl;

@Service
public class TicketService {
	
	TicketDaoImpl tDao = new TicketDaoImpl();

	@Autowired
	public TicketService(TicketDaoImpl tDao) {
		super();
		this.tDao = tDao;
	}
	
	public Ticket createTicket(Ticket ticket) {
		tDao.insert(ticket);
		return ticket;
	}
	
}
