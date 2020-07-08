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
@Table(name = "user")
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
}
