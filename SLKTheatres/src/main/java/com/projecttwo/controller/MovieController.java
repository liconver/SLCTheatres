package com.projecttwo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projecttwo.model.Movie;
import com.projecttwo.model.Users;
import com.projecttwo.services.MovieService;

@RestController("MovieController")
@RequestMapping("/api")
@CrossOrigin("*")
public class MovieController {
	
	MovieService movieService;

	public MovieController() {
	}
	
	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@RequestMapping(value = "/getmovies", method=RequestMethod.GET) 
	public List<Movie> getMovies() {
		System.out.println("in getMovies,");
		return movieService.getMovies();
	}
	
	@RequestMapping(value = "/getmovie/{movie_id}", method=RequestMethod.GET) 
	public Movie getMovieById(@PathVariable("movie_id") int id) {
		System.out.println("in getMovieById, id= "+id);
		return movieService.getMovieById(id);
	}

}
