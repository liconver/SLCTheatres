package com.projecttwo.model;

import java.sql.Timestamp;

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
@Table(name = "Showing")
public class Showing {

	@Id
	@Column(name = "showing_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int showingId;
	@Column(name = "showtime", nullable = false)
	private Timestamp showtime;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Movie movie;
	
	public Showing() {
	}

	public Showing(int showingId, Timestamp showtime) {
		super();
		this.showingId = showingId;
		this.showtime = showtime;
	}
	
	public Showing(Timestamp showtime) {
		super();
		this.showtime = showtime;
	}
	
	public Showing(int showingId, Timestamp showtime, Movie movie) {
		super();
		this.showingId = showingId;
		this.showtime = showtime;
		this.movie = movie;
	}

	public int getShowingId() {
		return showingId;
	}

	public void setShowingId(int showingId) {
		this.showingId = showingId;
	}

	public Timestamp getShowtime() {
		return showtime;
	}

	public void setShowtime(Timestamp showtime) {
		this.showtime = showtime;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Showing [showingId=" + showingId + ", showtime=" + showtime + ", movie=" + movie + "]";
	}

}
