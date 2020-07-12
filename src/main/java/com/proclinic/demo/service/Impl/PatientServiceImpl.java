package com.proclinic.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proclinic.demo.entity.Patient;
import com.proclinic.demo.repository.PatientRepository;
import com.proclinic.demo.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepository patientRepository;

	@Override
	public List<Patient> finallpname(int id) {
	List<Patient>pnameList=patientRepository.findAllpname(id);
		return pnameList;
	}
}
