package com.proclinic.demo.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name = "charges", length = 10)
    private BigDecimal charges;

    @Column(name = "charges_date")
    private Date chargesDate;

    @Column(name = "status", length = 10)
    private String status;

    @OneToMany
    @JoinColumn(name = "payment_id")
    @JsonIgnore
    private List<Service> services;

    public Payment() {
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public Patient getPatient() {
	return patient;
    }

    public void setPatient(Patient patient) {
	this.patient = patient;
    }

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

    public Department getDepartment() {
	return department;
    }

    public void setDepartment(Department department) {
	this.department = department;
    }

    public BigDecimal getCharges() {
	return charges;
    }

    public void setCharges(BigDecimal charges) {
	this.charges = charges;
    }

    public Date getChargesDate() {
	return chargesDate;
    }

    public void setChargesDate(Date chargesDate) {
	this.chargesDate = chargesDate;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public List<Service> getServices() {
	return services;
    }

    public void setServices(List<Service> services) {
	this.services = services;
    }

}
