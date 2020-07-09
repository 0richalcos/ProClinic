package com.proclinic.demo.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "age", length = 3)
    private int age;

    @Column(name = "phone", length = 11)
    private String phone;

    @Column(name = "email", length = 20)
    private String email;

    @Column(name = "gener", length = 10)
    private String gener;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "status", length = 10)
    private String status;

    @OneToMany
    @JoinColumn(name = "patient_id")
    private List<Payment> payments;

    @OneToMany
    @JoinColumn(name = "patient_id")
    private List<Appointment> appointments;

    public Patient() {
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

    public Date getBirthday() {
	return birthday;
    }

    public void setBirthday(Date birthday) {
	this.birthday = birthday;
    }

    public int getAge() {
	return age;
    }

    public void setAge(int age) {
	this.age = age;
    }

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getGener() {
	return gener;
    }

    public void setGener(String gener) {
	this.gener = gener;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
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
