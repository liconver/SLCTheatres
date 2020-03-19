package com.projecttwo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projecttwo.model.Showing;

@Transactional
@Repository("showingDao")
public class ShowingDaoImpl /*implements ShowingDao*/ {
	
	private SessionFactory sesFact;
	
	public ShowingDaoImpl() {
	}
	
	@Autowired
	public ShowingDaoImpl(SessionFactory sesFact) {
		super();
		this.sesFact = sesFact;
	}

	public void insert(Showing showing) {
		sesFact.getCurrentSession().save(showing);
	}

//	public void update(Showing showing) {
//		Session ses = HibernateUtil.getSession();
//		Transaction tx = ses.beginTransaction();
//
//		ses.update(showing);
//		tx.commit();
//	}

	public Showing selectById(int id) {
		return sesFact.getCurrentSession().get(Showing.class, id);
	}

	public List<Showing> selectAll() {
		return sesFact.getCurrentSession().createQuery("from Showing", Showing.class).list();
	}
}
