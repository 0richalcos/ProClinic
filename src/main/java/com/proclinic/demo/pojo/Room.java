package com.proclinic.demo.pojo;

import java.sql.Date;

public class Room {
 private Integer id;//房间号
 private String type;//房间类型
 private Integer size;//房间容量(人)
 private String status;//状态
 private Integer patient_id;//病人id
 private Integer user_id;//用户ID\医生id
 private Date allotment_date; //入主日期
 private Date  discharge_date;//出院日期
 public Room() {
	// TODO Auto-generated constructor stub
}

 
public Integer getPatient_id() {
	return patient_id;
}


public void setPatient_id(Integer patient_id) {
	this.patient_id = patient_id;
}


public Integer getUser_id() {
	return user_id;
}


public void setUser_id(Integer user_id) {
	this.user_id = user_id;
}


public Date getAllotment_date() {
	return allotment_date;
}


public void setAllotment_date(Date allotment_date) {
	this.allotment_date = allotment_date;
}


public Date getDischarge_date() {
	return discharge_date;
}


public void setDischarge_date(Date discharge_date) {
	this.discharge_date = discharge_date;
}


public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public Integer getSize() {
	return size;
}

public void setSize(Integer size) {
	this.size = size;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}
 
	
}
