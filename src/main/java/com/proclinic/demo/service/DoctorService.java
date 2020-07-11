package com.proclinic.demo.service;

import java.util.List;


import com.proclinic.demo.entity.UserDesc;

public interface DoctorService {
	//查询医生详情
		UserDesc findAllBy(int id);
		//添加医生信息
		String adddoctor(UserDesc userdesc );
		//修改医生信息
		String updatedoctor(UserDesc userdesc,int id);
		//批量删除医生信息
		Boolean deletedoctor(String[] list);
}
