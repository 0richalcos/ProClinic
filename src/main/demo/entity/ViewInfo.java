package com.proclinic.demo.entity;

import java.io.Serializable;

public class ViewInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6784526645914673098L;
private User user;
private Patient p;
private RoomDesc r;
public ViewInfo() {
	// TODO Auto-generated constructor stub
}


public ViewInfo(User user, Patient p, RoomDesc r) {

	this.user = user;
	this.p = p;
	this.r = r;
}

	
}
