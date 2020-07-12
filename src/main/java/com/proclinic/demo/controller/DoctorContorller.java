package com.proclinic.demo.controller;

import java.util.List;

import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.proclinic.demo.entity.UserDesc;
import com.proclinic.demo.repository.DoctorRepository;
import com.proclinic.demo.service.DoctorService;

@RestController
public class DoctorContorller {
	@Autowired
	DoctorRepository doctorrepository;
	@Autowired
	DoctorService doctorservce;


	@GetMapping("/doctor")
	public List<UserDesc> list() {
		return doctorrepository.findAll();
	}
	@GetMapping("/doctor/{id}")
	public UserDesc save(@PathVariable int id) {
		return doctorservce.findAllBy(id);
	}
	//X_X
	@CrossOrigin
	@PostMapping("/doctor")
	public String add(@RequestBody UserDesc userdesc) {
		System.out.println(userdesc.getUser().getUsername());
		return doctorservce.adddoctor(userdesc);
	}
	//X_X
	@DeleteMapping("/doctor")     
	public boolean dele(@RequestBody String[] list) {
	return doctorservce.deletedoctor(list);
	}
	//X_X
	@PutMapping("/doctor/{id}")
	public String upde(@RequestBody UserDesc userdesc,@PathVariable int id) {
		return doctorservce.updatedoctor(userdesc,id);
	}
}
