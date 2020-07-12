package com.proclinic.demo.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name = "appointment_date")
    private Date appointmentDate;

    @Column(name = "time_slot", length = 50)
    private String timeSlot;

    @Column(name = "problem", length = 255)
    private String problem;

    @Column(name = "charges", length = 10)
    private BigDecimal charges;

    @Column(name = "status", length = 10)
    private String status;
    
    public Appointment() {
	}

	public Appointment(int id, User user, Patient patient, Department department, Date appointmentDate, String timeSlot,
			String problem, BigDecimal charges, String status) {
		this.id = id;
		this.user = user;
		this.patient = patient;
		this.department = department;
		this.appointmentDate = appointmentDate;
		this.timeSlot = timeSlot;
		this.problem = problem;
		this.charges = charges;
		this.status = status;
	}

	public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

    public Patient getPatient() {
	return patient;
    }

    public void setPatient(Patient patient) {
	this.patient = patient;
    }

    public Department getDepartment() {
	return department;
    }

    public void setDepartment(Department department) {
	this.department = department;
    }

    public Date getAppointmentDate() {
	return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
	this.appointmentDate = appointmentDate;
    }

    public String getTimeSlot() {
	return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
	this.timeSlot = timeSlot;
    }

    public String getProblem() {
	return problem;
    }

    public void setProblem(String problem) {
	this.problem = problem;
    }

    public BigDecimal getCharges() {
	return charges;
    }

    public void setCharges(BigDecimal charges) {
	this.charges = charges;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

}
