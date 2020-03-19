package com.projecttwo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Purchase")
public class Purchase {
	
	@Id
	@Column(name = "purchase_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int purchaseId;
	@Column(name = "total_cost", nullable = false)
	private double totalCost;
	
//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "user_id_FK")
//	private User userFK;
	
	public Purchase() {
	}

	public Purchase(int purchaseId, double totalCost) {
		super();
		this.purchaseId = purchaseId;
		this.totalCost = totalCost;
	}
	
	public Purchase(double totalCost) {
		super();
		this.totalCost = totalCost;
	}
	
//	public Purchase(int purchaseId, double totalCost, User userFK) {
//		super();
//		this.purchaseId = purchaseId;
//		this.totalCost = totalCost;
//		this.userFK = userFK;
//	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

//	public User getUser() {
//		return userFK;
//	}
//
//	public void setUser(User userFK) {
//		this.userFK = userFK;
//	}

	@Override
	public String toString() {
		return "Purchase [purchaseId=" + purchaseId + ", totalCost=" + totalCost + ", user=" + /*userFK +*/ "]";
	}

}
