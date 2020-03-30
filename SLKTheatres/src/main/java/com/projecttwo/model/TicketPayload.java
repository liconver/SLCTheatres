package com.projecttwo.model;

public class TicketPayload {
	private int id;
	private int typeId;
	
	public TicketPayload() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	@Override
	public String toString() {
		return "TicketPayload [id=" + id + ", typeId=" + typeId + "]";
	}
	
}
