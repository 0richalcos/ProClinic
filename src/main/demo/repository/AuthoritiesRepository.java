package com.proclinic.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proclinic.demo.entity.Authorities;

public interface AuthoritiesRepository extends JpaRepository<Authorities, Integer> {

}
