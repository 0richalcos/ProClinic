package com.proclinic.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proclinic.demo.entity.RoomDesc;

public interface RoomDescRepository extends JpaRepository<RoomDesc, Integer> {

}