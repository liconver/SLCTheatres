package com.projecttwo.dao;

import java.util.List;

import com.projecttwo.model.Movie;

public interface MovieDao {

	public void insert(Movie movie);
	
	public void update(Movie movie);
	
	public Movie selectById(int id);
	
	public Movie selectByTitle(String title);
	
	public List<Movie> selectAll();
	
}
