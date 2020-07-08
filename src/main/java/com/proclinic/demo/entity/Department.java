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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "department")
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
}
