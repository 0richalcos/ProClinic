package com.proclinic.demo.controller;

import java.util.List;

import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proclinic.demo.entity.UserDesc;
import com.proclinic.demo.repository.DoctorRepository;
import com.proclinic.demo.servce.DoctorServce;

@RestController
public class DoctorContorller {
	@Autowired
	DoctorRepository doctorrepository;
	@Autowired
	DoctorServce doctorservce;
	@GetMapping("/user/doctor")
	public Page<UserDesc> list(@RequestParam(name="p",defaultValue = "0") int page,@RequestParam(name="s",defaultValue = "2") int size) {
		return doctorrepository.findAll(PageRequest.of(page, size,Sort.by("id").descending()));
	}
	@GetMapping("/user/doctor/{id}")
	public UserDesc save(int id) {
		return doctorservce.findAllBy(id);
	}
	@PostMapping("/admin/doctor")
	public String add(UserDesc userdesc,String username,String departmentname) {
		return doctorservce.adddoctor(userdesc,username,departmentname);
	}
	@DeleteMapping("/admin/doctor")
	public boolean dele(List<String> list) {
		return doctorservce.deletedoctor(list);
		
	}
}
