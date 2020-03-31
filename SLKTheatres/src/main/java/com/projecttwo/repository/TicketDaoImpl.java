package com.projecttwo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projecttwo.model.Ticket;

@Transactional
@Repository("ticketDao")
public class TicketDaoImpl {

private SessionFactory sesFact;
	
	public TicketDaoImpl() {
	}

	@Autowired
	public TicketDaoImpl(SessionFactory sesFact) {
		super();
		this.sesFact = sesFact;
	}
	
	public void insert(Ticket ticket) {
		sesFact.getCurrentSession().save(ticket);
	}
	
	public Ticket selectById(int id) {
		return sesFact.getCurrentSession().get(Ticket.class, id);
	}
	
	public List<Ticket> selectAll(){
		System.out.println("get all tickets from db");
		return sesFact.getCurrentSession().createQuery("from Ticket", Ticket.class).list();
	}
	
	public List<Ticket> selectAllByUser(int userId) {
		List<Ticket> pList = sesFact.getCurrentSession().createQuery("select t from Ticket t inner join t.purchaseHolder where user_id_fk = '" + userId + "'", Ticket.class).list();
		if (pList.size() == 0) {
			System.out.println("Panic");
			return null;
		}
		return pList;
	}


}
