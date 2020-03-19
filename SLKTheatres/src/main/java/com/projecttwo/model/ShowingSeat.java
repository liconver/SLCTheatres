package com.projecttwo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@Override
	public String toString() {
		return "ShowingSeat [seatId=" + seatId + ", seatName=" + seatName + ", status=" + status + "]";
	}
	
	
}
