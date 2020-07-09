package com.proclinic.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proclinic.demo.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
