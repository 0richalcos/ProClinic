package com.proclinic.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proclinic.demo.entity.Patient;
import com.proclinic.demo.repository.PatientRepository;
import com.proclinic.demo.service.PatientService;



	

import org.springframework.stereotype.Service;

import com.proclinic.demo.entity.Patient;
import com.proclinic.demo.mapper.PatientMapper;
import com.proclinic.demo.repository.PatientRepository;
import com.proclinic.demo.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	PatientMapper patientMapper;
	
	@Autowired
	PatientRepository patientRepository;


	@Override
	public List<Patient> finallpname(int id) {
	List<Patient>pnameList=patientRepository.findAllpname(id);
		return pnameList;
	}
	@Override
	public Patient findAllBy(int id) {
		return patientRepository.findById(id).get();
	}

	@Override
	public void addPatient(Patient patient) {
		patientMapper.add(patient);
	}

	@Override
	public void updatePatient(Patient patient, int id) {
		// TODO 自动生成的方法存根
		patientMapper.updatepatient(patient, id);
	}

	@Override
	public void deletePatient(String[] list) {
		// TODO 自动生成的方法存根
		for(String  i:list) {
			patientMapper.delete(Integer.parseInt(i));;
		}
	}


}
