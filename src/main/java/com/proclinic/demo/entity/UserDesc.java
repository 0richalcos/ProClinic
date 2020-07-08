package com.proclinic.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_desc")
public class UserDesc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "specialization", length = 10)
    private String specialization;

    @Column(name = "experience", length = 10)
    private String experience;

    @Column(name = "gender", length = 10)
    private String gender;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "age", length = 11)
    private int age;

    @Column(name = "email", length = 20)
    private String email;

    @Column(name = "details", length = 255)
    private String details;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "phone", length = 11)
    private String phone;

    @Column(name = "status", length = 10)
    private String status;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
