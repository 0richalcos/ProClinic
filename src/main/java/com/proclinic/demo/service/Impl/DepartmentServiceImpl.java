package com.proclinic.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.proclinic.demo.entity.Department;
import com.proclinic.demo.entity.User;
import com.proclinic.demo.repository.DepartmentRepository;
import com.proclinic.demo.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	DepartmentRepository departmentrepositoryt;
	
	@Override
	public String selectname(int id) {
    Department department =departmentrepositoryt.findDepartmentByid(id);
	String name=department.getName();
		return name;
	}

}
