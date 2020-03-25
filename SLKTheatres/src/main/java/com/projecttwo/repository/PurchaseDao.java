package com.projecttwo.repository;

import java.util.List;

import com.projecttwo.model.Purchase;

public interface PurchaseDao {

	public void insert(Purchase purchase);
	
	public void update(Purchase purchase);
	
	public Purchase selectById(int id);
	
	public List<Purchase> selectAll();
}
