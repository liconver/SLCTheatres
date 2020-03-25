package com.projecttwo.repository;

import java.util.List;

import com.projecttwo.model.TicketType;

public interface TicketTypeDao {

	public void insert(TicketType ticketType);
	
	public TicketType selectById(int id);
	
	public List<TicketType> selectAll();
}
