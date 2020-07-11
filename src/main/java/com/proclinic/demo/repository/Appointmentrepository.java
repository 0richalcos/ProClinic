package com.proclinic.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proclinic.demo.entity.Appointment;

public interface Appointmentrepository extends JpaRepository<Appointment, Integer>{

}
