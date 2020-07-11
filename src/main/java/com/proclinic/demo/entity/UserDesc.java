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

    public UserDesc() {
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getSpecialization() {
	return specialization;
    }

    public void setSpecialization(String specialization) {
	this.specialization = specialization;
    }

    public String getExperience() {
	return experience;
    }

    public void setExperience(String experience) {
	this.experience = experience;
    }

    public String getGender() {
	return gender;
    }

    public void setGender(String gender) {
	this.gender = gender;
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

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getDetails() {
	return details;
    }

    public void setDetails(String details) {
	this.details = details;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
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

}
