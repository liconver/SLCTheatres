package com.projecttwo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="purchase_detail")
public class PurchaseDetail {

	@Id
	@Column (name="pd_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pdId;
	
//	@JoinColumn (name="purhase_id")
//	private Purchase purchase_id;
//	
//	@OneToMany(mappedBy="ticketHolder", fetch=FetchType.LAZY)
////	@JoinColumn (name="ticket_id")
//	private List<Ticket> ticketList = new ArrayList<>();
	
	public PurchaseDetail() {
	}
	
	

//	public PurchaseDetail(int pdId, Purchase purchase_id, List<Ticket> ticketList) {
//		super();
//		this.pdId = pdId;
//		this.purchase_id = purchase_id;
//		this.ticketList = ticketList;
//	}
//
//	public PurchaseDetail(Purchase purchase_id, List<Ticket> ticketList) {
//		super();
//		this.purchase_id = purchase_id;
//		this.ticketList = ticketList;
//	}

	public PurchaseDetail(int pdId) {
		super();
		this.pdId = pdId;
	}



	public int getPdId() {
		return pdId;
	}

	public void setPdId(int pdId) {
		this.pdId = pdId;
	}

//	public Purchase getPurchase_id() {
//		return purchase_id;
//	}
//
//	public void setPurchase_id(Purchase purchase_id) {
//		this.purchase_id = purchase_id;
//	}
//
//	public List<Ticket> getTicketList() {
//		return ticketList;
//	}
//
//	public void setTicketList(List<Ticket> ticketList) {
//		this.ticketList = ticketList;
//	}

	@Override
	public String toString() {
		return "PurchaseDetail [pdId=" + pdId + ", purchase_id=" + /*purchase_id + ", ticketList=" + ticketList + */"]";
	}
	
}
