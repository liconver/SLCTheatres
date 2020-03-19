package com.projecttwo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projecttwo.model.Purchase;

@Transactional
@Repository("purchaseDao")
public class PurchaseDaoImpl /*implements PurchaseDao*/{
	
	private SessionFactory sesFact;

	public PurchaseDaoImpl() {
	}
	
	@Autowired
	public PurchaseDaoImpl(SessionFactory sesFact) {
		super();
		this.sesFact = sesFact;
	}
	
	public void insert(Purchase purchase) {
		sesFact.getCurrentSession().save(purchase);
	}

//	public void update(Purchase purchase) {
//		Session ses = HibernateUtil.getSession();
//		Transaction tx = ses.beginTransaction();
//
//		ses.update(purchase);
//		tx.commit();
//	}

	public Purchase selectById(int id) {
		return sesFact.getCurrentSession().get(Purchase.class, id);
	}

	public List<Purchase> selectAll() {
		return sesFact.getCurrentSession().createQuery("from Purchase", Purchase.class).list();
	}
}
