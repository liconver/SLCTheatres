package com.projecttwo.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projecttwo.model.ShowingSeat;

@Transactional
@Repository("seatDao")
public class ShowingSeatDaoImpl /*implements ShowingSeatDao*/{
	
	private SessionFactory sesFact;
	
	public ShowingSeatDaoImpl() {
	}
	
	@Autowired
	public ShowingSeatDaoImpl(SessionFactory sesFact) {
		super();
		this.sesFact = sesFact;
	}

	public void insert(ShowingSeat showingSeat) {
		sesFact.getCurrentSession().save(showingSeat);
	}

	public void update(ShowingSeat showingSeat) {
		sesFact.getCurrentSession().update(showingSeat);
	}

	public ShowingSeat selectById(int id) {
		return sesFact.getCurrentSession().get(ShowingSeat.class, id);
	}
	
	public ShowingSeat selectByName(String seatName) {
		List<ShowingSeat> seatList = sesFact.getCurrentSession().createQuery("from ShowingSeat where seat_name = '" + seatName + "'", ShowingSeat.class).list();
		if (seatList.isEmpty()) {
			System.err.println("No Seats Found!");
			return null;
		}
		return seatList.get(0);
	}
	
	public ShowingSeat selectByStatus(int status) {
		List<ShowingSeat> seatList = sesFact.getCurrentSession().createQuery("from ShowingSeat where status = '" + status + "'", ShowingSeat.class).list();
		if (seatList.isEmpty()) {
			System.err.println("No Seats Found!");
			return null;
		}
		return seatList.get(0);
	}

	public List<ShowingSeat> selectAll() {
		return sesFact.getCurrentSession().createQuery("from ShowingSeat", ShowingSeat.class).list();
	}
}
