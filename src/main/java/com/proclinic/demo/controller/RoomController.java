package com.proclinic.demo.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proclinic.demo.entity.Patient;
import com.proclinic.demo.entity.Room;
import com.proclinic.demo.entity.RoomDesc;
import com.proclinic.demo.entity.User;
import com.proclinic.demo.repository.PatientRepository;
import com.proclinic.demo.repository.RoomDescRepository;
import com.proclinic.demo.repository.RoomRepository;
import com.proclinic.demo.repository.UserRepository;
import com.proclinic.demo.service.RoomDescService;
import com.proclinic.demo.service.Impl.UserServiceImpl;

@RestController
@RequestMapping("/room")
public class RoomController {

	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	PatientRepository patientRepository;
	@Autowired
	RoomDescRepository roomDescRepository; 
	@Autowired
	RoomDescService service;
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@GetMapping("/{id}")
	public String selid(@PathVariable int id) {
		Room r=roomRepository.findById(id).get();
		return r.getType() ;
	}
	@GetMapping("/User/{uid}")
	public String seluid(@PathVariable int uid) {
		
		return userServiceImpl.selname(uid) ;
	}

	@GetMapping("/patient/{pid}")
	public String selpid(@PathVariable int pid) {
		Patient p=patientRepository.findById(pid).get();
		System.out.println(p.getName());
		return p.getName();
	}
	
	@PostMapping("/add")
	@ResponseBody
	public int add(Integer id, Integer pid,String allotmentDate,String dischargeDate, Integer uid) throws ParseException {
		System.out.println(id+pid+ allotmentDate+dischargeDate+ uid);
		 int count=0;
	Room room=new Room();
	room.setId(id);
	Patient patient=new Patient();
	patient.setId(pid);
	User user=new User();
	user.setId(uid);
	Date date = new SimpleDateFormat("yyyy-MM-dd").parse(allotmentDate); 
	Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(allotmentDate); 

  RoomDesc d= roomDescRepository.save
 (new RoomDesc(patient,user,room, date, date2));
  if(d!=null) {
	  count=1;
  }
		return count;
	}
	
	@GetMapping("/all")
	public List<RoomDesc> all(){
		
		return service.findAll() ;
	}
	
	
	
}
