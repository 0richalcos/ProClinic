package com.proclinic.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proclinic.demo.entity.RoomDesc;
import com.proclinic.demo.repository.RoomDescRepository;

@RestController
@RequestMapping("/roomdesc")
public class RoomDescController {

	@Autowired
	RoomDescRepository roomDescRepository;
	
	@PostMapping("/roomdesc/add")
	public int add(RoomDesc sc) {
		roomDescRepository.save(sc);
		return 0;
	}
}
