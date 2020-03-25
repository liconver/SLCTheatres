package com.projecttwo.model;

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
@Table(name = "Showing_Seat")
public class ShowingSeat {

	@Id
	@Column(name = "seat_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int seatId;
	@Column(name = "seat_name", unique = true, nullable = false)
	private String seatName;
	@Column(name = "status")
	private int status;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "showing_id_FK")
	private Showing showingIdFK;
	
	@OneToOne(mappedBy= "seat_id_FK", fetch = FetchType.EAGER)
	private Ticket ticket;
	
	public ShowingSeat() {
	}

	public ShowingSeat(int seatId, String seatName, int status) {
		super();
		this.seatId = seatId;
		this.seatName = seatName;
		this.status = status;
	}
	
	public ShowingSeat(String seatName, int status) {
		super();
		this.seatName = seatName;
		this.status = status;
	}
	
	public ShowingSeat(int seatId, String seatName, int status, Showing showingIdFK) {
		super();
		this.seatId = seatId;
		this.seatName = seatName;
		this.status = status;
		this.showingIdFK = showingIdFK;
	}
	
	public ShowingSeat(String seatName, int status, Showing showingIdFK) {
		super();
		this.seatName = seatName;
		this.status = status;
		this.showingIdFK = showingIdFK;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public String getSeatName() {
		return seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Showing getShowingIdFK() {
		return showingIdFK;
	}

	public void setShowingIdFK(Showing showingIdFK) {
		this.showingIdFK = showingIdFK;
	}

	@Override
	public String toString() {
		return "ShowingSeat [seatId=" + seatId + ", seatName=" + seatName + ", status=" + status + ", showingIdFK="
				+ showingIdFK.getShowingId() + "]";
	}
	
}
