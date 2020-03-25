package com.projecttwo.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projecttwo.model.TicketType;

@Transactional
@Repository("ticketTypeDao")
public class TicketTypeDaoImpl {
	
		private SessionFactory sessFact;
		public TicketTypeDaoImpl() {
		}
		
		@Autowired
		public TicketTypeDaoImpl(SessionFactory sessFact) {
			super();
			this.sessFact = sessFact;
		}
		
		public void insert(TicketType ticketType) {
			sessFact.getCurrentSession().save(ticketType);
		}
		
		public TicketType selectById(int id) {
			return sessFact.getCurrentSession().get(TicketType.class, id);
		}
		
		public List<TicketType> selectAll(){
			return sessFact.getCurrentSession().createQuery("from ticketType",TicketType.class).list();
		}
		
}
