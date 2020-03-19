package com.projecttwo.dao;

import java.util.List;

import com.projecttwo.model.Showing;

public interface ShowingDao {

	public void insert(Showing showing);
	
	public void update(Showing showing);
	
	public Showing selectById(int id);
	
	public List<Showing> selectAll();
}
