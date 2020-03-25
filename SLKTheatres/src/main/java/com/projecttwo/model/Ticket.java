package com.projecttwo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="ticket")
public class Ticket {
	
	@Id
	@Column (name="ticket_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ticketId;
	
//	@OneToOne(fetch=FetchType.LAZY)
//	@JoinColumn (name="seat_id_FK")
//	private int seatId;
//	@OneToOne(fetch=FetchType.LAZY)
//	@JoinColumn (name="ticket_type_id_FK")
//	private TicketType ticketTypeId;
	
	public Ticket() {
	}

	public Ticket(int ticketId) {
		super();
		this.ticketId = ticketId;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	
	
	
//	public Ticket(int ticketId, int seatId, TicketType ticketTypeId) {
//		super();
//		this.ticketId = ticketId;
//		this.seatId = seatId;
//		this.ticketTypeId = ticketTypeId;
//	}
//	
//	public Ticket(int seatId, TicketType ticketTypeId) {
//		super();
//		this.seatId = seatId;
//		this.ticketTypeId = ticketTypeId;
//	}
//
//	public int getTicketId() {
//		return ticketId;
//	}
//
//	public void setTicketId(int ticketId) {
//		this.ticketId = ticketId;
//	}
//
//	public int getSeatId() {
//		return seatId;
//	}
//
//	public void setSeatId(int seatId) {
//		this.seatId = seatId;
//	}
//
//	public TicketType getTicketTypeId() {
//		return ticketTypeId;
//	}
//
//	public void setTicketTypeId(TicketType ticketTypeId) {
//		this.ticketTypeId = ticketTypeId;
//	}
//
//	@Override
//	public String toString() {
//		return "Ticket [ticketId=" + ticketId + ", seatId=" + seatId + ", ticketTypeId=" + ticketTypeId + "]";
//	}

}