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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({ "roomDescs", "authorities", "payments", "appointments" })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "enabled", length = 4)
    private int enabled = 1;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<RoomDesc> roomDescs;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Authorities> authorities;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Payment> payments;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Appointment> appointments;

    public User() {
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public int getEnabled() {
	return enabled;
    }

    public void setEnabled(int enabled) {
	this.enabled = enabled;
    }

    public List<RoomDesc> getRoomDescs() {
	return roomDescs;
    }

    public void setRoomDescs(List<RoomDesc> roomDescs) {
	this.roomDescs = roomDescs;
    }

    public List<Authorities> getAuthorities() {
	return authorities;
    }

    public void setAuthorities(List<Authorities> authorities) {
	this.authorities = authorities;
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
