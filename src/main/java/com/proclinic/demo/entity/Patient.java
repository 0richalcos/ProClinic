package com.proclinic.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
