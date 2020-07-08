package com.proclinic.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proclinic.demo.entity.UserDesc;
import com.proclinic.demo.repository.DoctorRepository;

@RestController
public class DoctorContorller {
	@Autowired
	DoctorRepository doctorrepository;
	
	@GetMapping
	public Page<UserDesc> list(@RequestParam(name="p",defaultValue = "0") int page,@RequestParam(name="s",defaultValue = "2") int size) {
		return doctorrepository.findAll(PageRequest.of(page, size,Sort.by("id").descending()));
	}
}
