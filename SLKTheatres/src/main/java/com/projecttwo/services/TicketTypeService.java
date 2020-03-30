package com.projecttwo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projecttwo.model.TicketType;
import com.projecttwo.repository.TicketTypeDaoImpl;

@Service
public class TicketTypeService {

	TicketTypeDaoImpl tDao = new TicketTypeDaoImpl();

	@Autowired
	public TicketTypeService(TicketTypeDaoImpl tDao) {
		super();
		this.tDao = tDao;
	}

	public TicketType getTicketType(int id) {
		return tDao.selectById(id);
	}
	

	
}
