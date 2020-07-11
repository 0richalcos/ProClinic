package com.proclinic.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proclinic.demo.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {

}
