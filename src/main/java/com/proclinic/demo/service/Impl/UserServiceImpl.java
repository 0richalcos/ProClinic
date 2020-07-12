package com.proclinic.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proclinic.demo.entity.Authorities;
import com.proclinic.demo.entity.Department;
import com.proclinic.demo.entity.User;
import com.proclinic.demo.repository.AuthoritiesRepository;
import com.proclinic.demo.repository.DepartmentRepository;
import com.proclinic.demo.repository.UserRepository;
import com.proclinic.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthoritiesRepository authoritiesRepository;
    @Autowired
    DepartmentRepository depart;

    @Override
    public String register(User user) {
	User findUser = userRepository.findUserByUserName(user.getUsername());
	if (findUser == null) {
	    Authorities authorities = new Authorities(user, "ROLE_USER");
	    if (userRepository.save(user) != null && authoritiesRepository.save(authorities) != null) {
		return "OK";
	    }
	    return "NO";
	}
	return "用户名已存在，请登录";
    }

    
	@Override
	public String selname(int id) {
	User user =userRepository.findUserByid(id);
		return user.getUsername();
	}


	@Override//查询所有科室的方法
	public List<Department> selde(int id) {
		return depart.findAll();
	}

}
