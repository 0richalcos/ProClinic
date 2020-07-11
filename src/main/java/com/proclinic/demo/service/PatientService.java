package com.proclinic.demo.service;

import com.proclinic.demo.entity.Patient;

public interface PatientService {

	//查询病人详情
	Patient findAllBy(int id);
	//添加病人信息
	void addPatient(Patient patient );
	//修改病人信息
	String updatePatient(Patient patient,int id);
	//删除病人信息
	void deletePatient(String[] list);
}
