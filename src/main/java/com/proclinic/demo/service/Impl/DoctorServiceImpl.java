package com.proclinic.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proclinic.demo.entity.Department;
import com.proclinic.demo.entity.User;
import com.proclinic.demo.entity.UserDesc;
import com.proclinic.demo.mapper.DoctorMapper;
import com.proclinic.demo.repository.DoctorRepository;
import com.proclinic.demo.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{
	@Autowired
	DoctorMapper doctormapper;
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Override
	public UserDesc findAllBy(int id) {
		return doctorRepository.findById(id).get();
	}

	@Override
	public String adddoctor(UserDesc userdesc) {
		User user = doctormapper.Doctorid(userdesc.getUser().getUsername());
		Department department = doctormapper.Doctordepartment(userdesc.getDepartment().getName());
		UserDesc doctorname = doctormapper.doctorname(user.getId());
		System.out.println(user!=null);
		System.out.println(department!=null);
		System.out.println(doctorname==null);
		if(user!=null) {
			if(department!=null) {
				if(doctorname==null) {
				userdesc.setUser(user);
				userdesc.setDepartment(department);
				doctormapper.Doctoradd(userdesc);
				return "添加成功";
				}else{
					return "已有此成员";
				}
			}else{
				return "部门错误，没有此部门";
			}
		}else{
			return "错误，此人非本医院成员";
		}
		
		
	}

	@Override
	public String updatedoctor(UserDesc userdesc,int id) {
		User user = doctormapper.Doctorid(userdesc.getUser().getUsername());
		Department department = doctormapper.Doctordepartment(userdesc.getDepartment().getName());
		if(user!=null) {
			if(department!=null) {
				userdesc.setUser(user);
				userdesc.setDepartment(department);
				doctormapper.Doctorup(userdesc,id);
				return "修改成功";
			}else{
				return "部门错误，没有此部门";
			}
		}else {
			return "错误，此人非本医院成员";
		}
	}

	@Override
	public Boolean deletedoctor(String[] list) {
		int k=0;
		for(String  i:list) {
			k++;
			System.out.println(k);
			doctormapper.Doctordelete(Integer.parseInt(i));
		}
		return true;
	}
}
