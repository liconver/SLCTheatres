package com.projecttwo.repository;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projecttwo.model.PurchaseDetail;


@Transactional
@Repository("purchaseDetailDao")
public class PurchaseDetailDaoImpl {
	
	private SessionFactory sesFact;
	
	public PurchaseDetailDaoImpl() {
	}

	@Autowired 
	public PurchaseDetailDaoImpl(SessionFactory sesFact) {
		super();
		this.sesFact = sesFact;
	}
	
	public void insert(PurchaseDetail purchaseDetail) {
		sesFact.getCurrentSession().save(purchaseDetail);
	}
	
	public PurchaseDetail selectById(int id) {
		return sesFact.getCurrentSession().get(PurchaseDetail.class, id);
	}
	
	public List<PurchaseDetail> selectAll(){
		return sesFact.getCurrentSession().createQuery("from PurchaseDetail", PurchaseDetail.class).list();
	}

}