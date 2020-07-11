package com.proclinic.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "department")
@JsonIgnoreProperties({ "userDescs", "payments", "appointments" })
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 10)
    private String name;

    @OneToMany
    @JoinColumn(name = "department_id")
    private List<UserDesc> userDescs;

    @OneToMany
    @JoinColumn(name = "department_id")
    private List<Payment> payments;

    @OneToMany
    @JoinColumn(name = "department_id")
    private List<Appointment> appointments;

    public Department() {
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public List<UserDesc> getUserDescs() {
	return userDescs;
    }

    public void setUserDescs(List<UserDesc> userDescs) {
	this.userDescs = userDescs;
    }

    public List<Payment> getPayments() {
	return payments;
    }

    public void setPayments(List<Payment> payments) {
	this.payments = payments;
    }

    public List<Appointment> getAppointments() {
	return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
	this.appointments = appointments;
    }

}
