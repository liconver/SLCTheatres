package com.projecttwo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.projecttwo.model.ShowingSeat;
import com.projecttwo.repository.ShowingSeatDaoImpl;

@Service
public class ShowingSeatService {

	ShowingSeatDaoImpl ssDao = new ShowingSeatDaoImpl();

	@Autowired
	public ShowingSeatService(ShowingSeatDaoImpl ssDao) {
		super();
		this.ssDao = ssDao;
	}
	
	public List<ShowingSeat> getSeats(){
		return ssDao.selectAll();
	}
	
	public List<ShowingSeat> getSeatsFromShowing(int id){
		return ssDao.selectAllFromShowing(id);
	}
	
	public ShowingSeat getSeatById(int id){
		return ssDao.selectById(id);
	}
	
	public void updateSeat(ShowingSeat showingSeat) {
		ssDao.update(showingSeat);
	}
}
