package com.proclinic.demo.servce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proclinic.demo.entity.Department;
import com.proclinic.demo.entity.User;
import com.proclinic.demo.entity.UserDesc;
import com.proclinic.demo.mapper.DoctorMapper;

@Service
public class DoctorServceImpl implements DoctorServce{
	@Autowired
	DoctorMapper doctormapper;
	@Override
	public UserDesc findAllBy(int id) {
		return doctormapper.DoctorInformation(id);
	}

	@Override
	public String adddoctor(UserDesc userdesc,String username,String departmentname) {
		User user = doctormapper.Doctorid(username);
		Department department = doctormapper.Doctordepartment(departmentname);
		if(user!=null) {
			if(department!=null) {
				userdesc.setUser(user);
				userdesc.setDepartment(department);
				doctormapper.Doctoradd(userdesc);
				return "添加成功";
			}else{
				return "部门错误，此人非本部门人员";
			}
		}else {
			return "错误，此人非本医院成员";
		}
		
		
	}

	@Override
	public String updatedoctor(UserDesc userdesc,String username,String departmentname) {
		User user = doctormapper.Doctorid(username);
		Department department = doctormapper.Doctordepartment(departmentname);
		if(user!=null) {
			if(department!=null) {
				userdesc.setUser(user);
				userdesc.setDepartment(department);
				doctormapper.Doctorup(userdesc);
				return "修改成功";
			}else{
				return "部门错误，此人非本部门人员";
			}
		}else {
			return "错误，此人非本医院成员";
		}
	}

	@Override
	public Boolean deletedoctor(List<String> list) {
		for(String  i:list) {
			
		}
		return null;
	}

}
