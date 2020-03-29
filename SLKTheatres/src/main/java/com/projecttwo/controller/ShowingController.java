package com.projecttwo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projecttwo.model.Movie;
import com.projecttwo.model.Showing;
import com.projecttwo.services.MovieService;
import com.projecttwo.services.ShowingService;

@RestController("ShowingController")
@RequestMapping("/api")
@CrossOrigin("*")
public class ShowingController {

	ShowingService showingService;

	
	@Autowired
	public ShowingController(ShowingService showingService) {
		this.showingService = showingService;
	}
	
	@RequestMapping(value = "/getshowings/{movie_id}", method=RequestMethod.GET) 
	public List<Showing> getShowingsByMovie(@PathVariable("movie_id") int id) {
		System.out.println("in getShowingsByMovie, id= "+id);
		return showingService.getShowings(id);
	}
	
	@RequestMapping(value = "/getshowing/{showing_id}", method=RequestMethod.GET) 
	public Showing getShowingById(@PathVariable("showing_id") int id) {
		System.out.println("in getShowingById, id= "+id);
		return showingService.getMovieById(id);
	}
}
