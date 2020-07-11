package com.proclinic.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proclinic.demo.entity.UserDesc;

@Repository
public interface DoctorRepository extends JpaRepository<UserDesc, Integer> {


}
