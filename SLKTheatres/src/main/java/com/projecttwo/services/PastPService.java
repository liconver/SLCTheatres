package com.projecttwo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projecttwo.model.Purchase;
import com.projecttwo.model.Ticket;
import com.projecttwo.repository.TicketDaoImpl;

@Service
public class PastPService {

	TicketDaoImpl tDao = new TicketDaoImpl();

	public PastPService() {
	}

	@Autowired
	public PastPService(TicketDaoImpl tDao) {
		super();
		this.tDao = tDao;
	}
	
	public List<Ticket> getAllPurchases() {
		return tDao.selectAll();
	}
	
	public List<Ticket> getAllByUser(int userId) {
		return tDao.selectAllByUser(userId);
	}
}
