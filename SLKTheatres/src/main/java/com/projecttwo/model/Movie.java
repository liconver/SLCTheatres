package com.projecttwo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Movie")
public class Movie {

	@Id
	@Column(name = "movie_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int movieId;
	@Column(name = "title", nullable = false)
	private String title;
	@Column(name = "description", unique = true, nullable = false)
	private String description;
	@Column(name = "duration", nullable = false)
	private int duration;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Showing showing;
	 
	public Movie() {
	}

	public Movie(int movieId, String title, String description, int duration) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.description = description;
		this.duration = duration;
	}
	
	public Movie(String title, String description, int duration) {
		super();
		this.title = title;
		this.description = description;
		this.duration = duration;
	}
	
	public Movie(int movieId, String title, String description, int duration, Showing showing) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.description = description;
		this.duration = duration;
		this.showing = showing;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Showing getShowing() {
		return showing;
	}

	public void setShowing(Showing showing) {
		this.showing = showing;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", description=" + description + ", duration="
				+ duration + ", showing=" + showing + "]";
	}
	
}
