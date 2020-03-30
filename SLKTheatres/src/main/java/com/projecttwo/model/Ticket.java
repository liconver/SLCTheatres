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
	private ShowingSeat seatHolder;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "ticket_type_id_FK")
	private TicketType ticketTypeHolder;
	
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "purchase_id_FK")
	private Purchase purchaseHolder;
	
	public Ticket() {
	}

	public Ticket(int ticketId, ShowingSeat seatHolder, TicketType ticketTypeHolder, Purchase purchaseHolder) {
		super();
		this.ticketId = ticketId;
		this.seatHolder = seatHolder;
		this.ticketTypeHolder = ticketTypeHolder;
		this.purchaseHolder = purchaseHolder;
	}

	public Ticket(ShowingSeat seatHolder, TicketType ticketTypeHolder, Purchase purchaseHolder) {
		super();
		this.seatHolder = seatHolder;
		this.ticketTypeHolder = ticketTypeHolder;
		this.purchaseHolder = purchaseHolder;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public ShowingSeat getSeatHolder() {
		return seatHolder;
	}

	public void setSeatHolder(ShowingSeat seatHolder) {
		this.seatHolder = seatHolder;
	}

	public TicketType getTicketTypeHolder() {
		return ticketTypeHolder;
	}

	public void setTicketTypeHolder(TicketType ticketTypeHolder) {
		this.ticketTypeHolder = ticketTypeHolder;
	}

	public Purchase getPurchaseHolder() {
		return purchaseHolder;
	}

	public void setPurchaseHolder(Purchase purchaseHolder) {
		this.purchaseHolder = purchaseHolder;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", seatIdFK=" + seatHolder.getSeatId() + ", ticketTypeIdFK=" + ticketTypeHolder.getTicketTypeId() + ", purchaseIdFK=" + purchaseHolder.getPurchaseId()
				+ "]";
	}
	
}