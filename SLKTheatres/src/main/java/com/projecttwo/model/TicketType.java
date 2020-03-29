package com.projecttwo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TicketType")
public class TicketType {
	
	@Id
	@Column(name="Ticket_Type_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ticketTypeId;
	@Column(name="TicketType", nullable=false)
	private String ticketType;
	@Column(name="Price")
	private Double price;
	
	@OneToMany(mappedBy= "ticketTypeHolder", fetch = FetchType.EAGER)
	private List<Ticket> ticket;
	
	public TicketType() {
		super();
	}

	public TicketType(int ticketTypeId, String ticketType, Double price) {
		super();
		this.ticketTypeId = ticketTypeId;
		this.ticketType = ticketType;
		this.price = price;
	}
	
	public TicketType(String ticketType, Double price) {
		super();
		this.ticketType = ticketType;
		this.price = price;
	}

	public int getTicketTypeId() {
		return ticketTypeId;
	}

	public void setTicketTypeId(int ticketTypeId) {
		this.ticketTypeId = ticketTypeId;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "TicketType [ticketTypeId=" + ticketTypeId + ", ticketType=" + ticketType + ", price=" + price + "]";
	}
	
}