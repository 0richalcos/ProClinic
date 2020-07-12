package com.proclinic.demo.service;


import java.util.List;

import com.proclinic.demo.entity.Patient;

public interface PatientService {

	//查询病人详情
	Patient findAllBy(int id);
	//添加病人信息
	void addPatient(Patient patient );
	//修改病人信息
	void updatePatient(Patient patient,int id);
	//删除多条病人信息
	void deletePatient(String[] list);

}
