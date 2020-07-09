package com.proclinic.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/{id}")
	public String selid(@PathVariable int id) {
		Room r=roomRepository.findById(id).get();
		return r.getType() ;
	}
	
	
	
}
