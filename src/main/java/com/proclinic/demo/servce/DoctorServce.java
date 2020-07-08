package com.proclinic.demo.servce;

import java.util.List;


import com.proclinic.demo.entity.UserDesc;

public interface DoctorServce {
	//查询医生详情
	UserDesc findAllBy(int id);
	//添加医生信息
	String adddoctor(UserDesc userdesc ,String username,String departmentname);
	//修改医生信息
	String updatedoctor(UserDesc userdesc,String username,String departmentname);
	//批量删除医生信息
	Boolean deletedoctor(List<String> list);
}
