package com.projecttwo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projecttwo.model.Movie;
import com.projecttwo.repository.MovieDaoImpl;

@Service
public class MovieService {
	
	MovieDaoImpl movDao;

	@Autowired
	public MovieService(MovieDaoImpl movDao) {
		this.movDao = movDao;
	}
	
	public List<Movie> getMovies() {
		return movDao.selectAll();
	}
	
	public Movie getMovieById(int id) {
		return movDao.selectById(id);
	}
	
	

}
