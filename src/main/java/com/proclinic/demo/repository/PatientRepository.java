package com.proclinic.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proclinic.demo.entity.Patient;


public interface PatientRepository extends JpaRepository<Patient,Integer> {

}
