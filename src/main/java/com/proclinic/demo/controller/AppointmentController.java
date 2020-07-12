package com.proclinic.demo.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proclinic.demo.entity.Appointment;
import com.proclinic.demo.repository.Appointmentrepository;
import com.proclinic.demo.repository.UserRepository;
import com.proclinic.demo.service.Impl.UserServiceImpl;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	@Autowired
	Appointmentrepository appointmentrepository;
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	UserServiceImpl userServiceImpl;

	//查询用户名
	@GetMapping("/User/{uid}")
	public String seluid(@PathVariable int uid) {

		return userServiceImpl.selname(uid);
	}

	//查询科室名
	@GetMapping("/Department/{did}")
	public String seldid(@PathVariable int did) {

		return userServiceImpl.selname(did);
	}

	@PostMapping("/addappointment")
	public Appointment addappointment(@RequestBody Appointment a) throws ParseException {
		System.out.println(a);

		Appointment app = appointmentrepository.save(a);

		return app;
	}
	
	@GetMapping("/app1")
	public List<Appointment> selectAll() {
		return appointmentrepository.findAll();
	}
	
	
	@GetMapping("/app2/{id}")
	public Optional<Appointment> selectById(@PathVariable int id) {
		return appointmentrepository.findById(id);
	}
	@PutMapping("/upd/{id}")
	public Appointment updAppointment(@PathVariable int id,@RequestBody Appointment appointment) {
		appointment.setId(id);
		return appointmentrepository.save(appointment);
	}
	
	@DeleteMapping("/app3/{id}")
	public ResponseEntity<String> remove(@PathVariable Integer id) {
		appointmentrepository.deleteById(id);
	    
	    return new ResponseEntity<String>(HttpStatus.OK);
	  }
}
