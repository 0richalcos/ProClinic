package com.proclinic.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proclinic.demo.entity.Room;

public interface RoomRepository extends JpaRepository<Room,Integer> {

}
