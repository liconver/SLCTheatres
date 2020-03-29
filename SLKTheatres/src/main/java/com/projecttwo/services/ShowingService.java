package com.projecttwo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projecttwo.model.Movie;
import com.projecttwo.model.Showing;
import com.projecttwo.repository.ShowingDaoImpl;
import com.projecttwo.repository.UserDaoImpl;

@Service("showingService")
public class ShowingService {
	
	ShowingDaoImpl sD;
	
	@Autowired
	public ShowingService(ShowingDaoImpl sDao) {
		this.sD = sDao;
	}
	
	public List<Showing> getShowings(int id) {
		return sD.selectShowingsMovie(id);
	}

}
