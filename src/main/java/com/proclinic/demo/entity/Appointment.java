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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointment")
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
}
