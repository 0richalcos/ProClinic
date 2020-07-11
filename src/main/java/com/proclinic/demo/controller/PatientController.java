package com.proclinic.demo.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proclinic.demo.entity.Patient;
import com.proclinic.demo.mapper.PatientMapper;
import com.proclinic.demo.repository.PatientRepository;
import com.proclinic.demo.service.PatientService;

@RestController
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@Autowired
	PatientRepository patientRepository;
	
	/**
	 * 查询所有
	 * @return
	 */
	@GetMapping("/patient")
	public List<Patient> list() {
		return patientRepository.findAll();
	}
	
	
	/**增加
	 * 
	 * @param patient
	 * @return
	 */
	@PostMapping("/add")
	public String add(@RequestBody Patient patient) {
	 patientService.addPatient(patient);
	 return "redirect:/patient";
	}
	
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody String[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
		patientService.deletePatient(list);;
	}
}
