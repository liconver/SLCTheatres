package com.projecttwo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Purchase")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "purchaseId")
public class Purchase {
	
	@Id
	@Column(name = "purchase_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int purchaseId;
	@Column(name = "total_cost", nullable = false)
	private double totalCost;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id_FK")
	private Users userHolder;
	
	@OneToMany(mappedBy = "purchaseHolder", fetch = FetchType.EAGER)
	private List<Ticket> tList = new ArrayList<>();
	
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

	public Purchase(int purchaseId, double totalCost, Users userHolder) {
		super();
		this.purchaseId = purchaseId;
		this.totalCost = totalCost;
		this.userHolder = userHolder;
	}
	
	public Purchase(double totalCost, Users userHolder) {
		super();
		this.totalCost = totalCost;
		this.userHolder = userHolder;
	}

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

	public Users getUserHolder() {
		return userHolder;
	}

	public void setUserIdFK(Users userHolder) {
		this.userHolder = userHolder;
	}

	public List<Ticket> gettList() {
		return tList;
	}

	public void settList(List<Ticket> tList) {
		this.tList = tList;
	}

	@Override
	public String toString() {
		return "Purchase [purchaseId=" + purchaseId + ", totalCost=" + totalCost + ", userIdFK=" + userHolder.getUserId() + "]";	//", tList=" + tList +
	}

}
