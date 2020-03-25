package com.projecttwo.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "movie_id_FK")
	private Movie movieIdFK;
	
	@OneToOne(mappedBy= "showing_id_FK", fetch = FetchType.EAGER)
	private ShowingSeat seat;
	
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
	
	public Showing(int showingId, Timestamp showtime, Movie movieIdFK) {
		super();
		this.showingId = showingId;
		this.showtime = showtime;
		this.movieIdFK = movieIdFK;
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

	public Movie getMovieIdFk() {
		return movieIdFK;
	}

	public void setMovie(Movie movieIdFK) {
		this.movieIdFK = movieIdFK;
	}

	@Override
	public String toString() {
		return "Showing [showingId=" + showingId + ", showtime=" + showtime + ", movieIdFK=" + movieIdFK.getMovieId() + ", seat="
				+ seat.getSeatId() + "]";
	}

}
