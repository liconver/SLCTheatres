package com.projecttwo.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Showing")
public class Showing {

	@Id
	@Column(name = "showing_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int showingId;
	@Column(name = "showtime", nullable = false)
	private String showtime;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "movie_id_FK")
	private Movie movieHolder;
	
	@OneToMany(mappedBy= "showingHolder", fetch = FetchType.EAGER) //
	private List<ShowingSeat> seat;
	
	public Showing() {
	}

	public Showing(int showingId, String showtime) {
		super();
		this.showingId = showingId;
		this.showtime = showtime;
	}
	
	public Showing(String showtime) {
		super();
		this.showtime = showtime;
	}
	
	public Showing(int showingId, String showtime, Movie movieHolder) {
		super();
		this.showingId = showingId;
		this.showtime = showtime;
		this.movieHolder = movieHolder;
	}

	public int getShowingId() {
		return showingId;
	}

	public void setShowingId(int showingId) {
		this.showingId = showingId;
	}

	public String getShowtime() {
		return showtime;
	}

	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}

	public Movie getMovieHolder() {
		return movieHolder;
	}

	public void setMovie(Movie movieHolder) {
		this.movieHolder = movieHolder;
	}

	@Override
	public String toString() {
		return "Showing [showingId=" + showingId + ", showtime=" + showtime + ", movieIdFK=" + movieHolder.getMovieId() + "]";
	}

}
