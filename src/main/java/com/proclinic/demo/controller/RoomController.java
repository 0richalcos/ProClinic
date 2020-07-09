package com.proclinic.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proclinic.demo.entity.Patient;
import com.proclinic.demo.entity.Room;
import com.proclinic.demo.entity.User;

import com.proclinic.demo.repository.PatientRepository;
import com.proclinic.demo.repository.RoomRepository;
import com.proclinic.demo.repository.UserRepository;

@RestController
@RequestMapping("/room")
public class RoomController {

	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/{id}")
	public String selid(@PathVariable int id) {
		Room r=roomRepository.findById(id).get();
		return r.getType() ;
	}
	@GetMapping("/User/{uid}")
	public String seluid(@PathVariable int uid) {
		User u=userRepository.findById(uid).get();
		return u.getUsername() ;
	}

	@GetMapping("/patient/{pid}")
	public String selpid(@PathVariable int pid) {
		Patient p=patientRepository.findById(pid).get();
		System.out.println(p.getName());
		return p.getName();
	}
	
	
}
