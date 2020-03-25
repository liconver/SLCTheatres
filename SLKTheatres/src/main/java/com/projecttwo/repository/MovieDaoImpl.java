package com.projecttwo.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projecttwo.model.Movie;

@Transactional
@Repository("movieDao")
public class MovieDaoImpl {
	
	private SessionFactory sesFact;
	
	public MovieDaoImpl() {
	}
	
	@Autowired
	public MovieDaoImpl(SessionFactory sesFact) {
		super();
		this.sesFact = sesFact;
	}
	
	public void insert(Movie movie) {
		sesFact.getCurrentSession().save(movie);
	}

	public void update(Movie movie) {
		sesFact.getCurrentSession().update(movie);
	}

	public Movie selectById(int id) {		
		return sesFact.getCurrentSession().get(Movie.class, id);
	}

	public Movie selectByTitle(String title) {
			List<Movie> movieList = sesFact.getCurrentSession().createQuery("from Movie where name = '" + title + "'", Movie.class).list();
			if (movieList.isEmpty()) {
				System.err.println("No Movies Found!");
				return null;
			}
			return movieList.get(0);
	}

	public List<Movie> selectAll() {
		return sesFact.getCurrentSession().createQuery("from Movie", Movie.class).list();
	}

}
