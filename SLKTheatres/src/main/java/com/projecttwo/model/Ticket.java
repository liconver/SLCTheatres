package com.projecttwo.model;

import javax.persistence.CascadeType;
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
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "seat_id_FK")
	private ShowingSeat seatIdFK;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "ticket_type_id_FK")
	private TicketType ticketTypeIdFK;
	
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "purchase_id_FK")
	private Purchase purchaseIdFK;
	
	public Ticket() {
	}

	public Ticket(int ticketId, ShowingSeat seatIdFK, TicketType ticketTypeIdFK, Purchase purchaseIdFK) {
		super();
		this.ticketId = ticketId;
		this.seatIdFK = seatIdFK;
		this.ticketTypeIdFK = ticketTypeIdFK;
		this.purchaseIdFK = purchaseIdFK;
	}

	public Ticket(ShowingSeat seatIdFK, TicketType ticketTypeIdFK, Purchase purchaseIdFK) {
		super();
		this.seatIdFK = seatIdFK;
		this.ticketTypeIdFK = ticketTypeIdFK;
		this.purchaseIdFK = purchaseIdFK;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public ShowingSeat getSeatIdFK() {
		return seatIdFK;
	}

	public void setSeatIdFK(ShowingSeat seatIdFK) {
		this.seatIdFK = seatIdFK;
	}

	public TicketType getTicketTypeIdFK() {
		return ticketTypeIdFK;
	}

	public void setTicketTypeIdFK(TicketType ticketTypeIdFK) {
		this.ticketTypeIdFK = ticketTypeIdFK;
	}

	public Purchase getPurchaseIdFK() {
		return purchaseIdFK;
	}

	public void setPurchaseIdFK(Purchase purchaseIdFK) {
		this.purchaseIdFK = purchaseIdFK;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", seatIdFK=" + seatIdFK.getSeatId() + ", ticketTypeIdFK=" + ticketTypeIdFK.getTicketTypeId() + ", purchaseIdFK=" + purchaseIdFK.getPurchaseId()
				+ "]";
	}
	
}