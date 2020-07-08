package com.proclinic.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proclinic.demo.entity.Room;
import com.proclinic.demo.repository.RoomRepository;

@RestController
@RequestMapping("/room")
public class RoomController {

	@Autowired
	RoomRepository roomRepository;
	
	@PostMapping("/room/selid")
	public Room selid(int  id) {
		return roomRepository.findById(id).get() ;
	}
	
	
	
}
