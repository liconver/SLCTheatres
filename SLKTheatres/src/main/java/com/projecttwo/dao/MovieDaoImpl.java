package com.projecttwo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projecttwo.model.Movie;

@Transactional
@Repository("movieDao")
public class MovieDaoImpl /*implements MovieDao*/{
	
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

//	public void update(Movie movie) {
//		Session ses = HibernateUtil.getSession();
//		Transaction tx = ses.beginTransaction();
//
//		ses.update(movie);
//		tx.commit();
//	}

	public Movie selectById(int id) {		
		return sesFact.getCurrentSession().get(Movie.class, id);
	}

//	public Movie selectByTitle(String title) {
//			Session ses = HibernateUtil.getSession();
//			List<Movie> movieList = ses.createQuery("from Movie where name = '" + title + "'", Movie.class).list();
//			if (movieList.isEmpty()) {
//				System.err.println("No Movies Found!");
//				return null;
//			}
//			return movieList.get(0);
//	}

	public List<Movie> selectAll() {
		return sesFact.getCurrentSession().createQuery("from Movie", Movie.class).list();
	}

}
