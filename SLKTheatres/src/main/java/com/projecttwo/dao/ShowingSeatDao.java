package com.projecttwo.dao;

import java.util.List;

import com.projecttwo.model.ShowingSeat;

public interface ShowingSeatDao {

	public void insert(ShowingSeat showingSeat);
	
	public void update(ShowingSeat showingSeat);
	
	public ShowingSeat selectById(int id);
	
	public ShowingSeat selectByName(String seatName);

	public ShowingSeat selectByStatus(int status);
	
	public List<ShowingSeat> selectAll();
}
