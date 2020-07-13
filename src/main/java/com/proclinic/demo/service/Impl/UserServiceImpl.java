package com.proclinic.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
	User user = userRepository.findUserByid(id);
	return user.getUsername();
    }

    @Override //查询所有科室的方法
    public List<Department> selde(int id) {
	return depart.findAll();
    }

    @Override
    public String check(String username, String email) {
	User user = userRepository.findUserByNameAndEmail(username, email);
	if (user == null) {
	    return "NO";
	}
	return "OK";
    }

    @Override
    public String reset(User user) {
	int id = userRepository.findUserByUserName(user.getUsername()).getId();
	user.setId(id);
	User save = userRepository.save(user);
	if (save == null) {
	    return "NO";
	}
	Authorities authorities = new Authorities(user, "ROLE_USER");
	authoritiesRepository.save(authorities);
	return "OK";
    }

    @Override
    public String change(String password) {
	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String username = userDetails.getUsername();
	User user = userRepository.findUserByUserName(username);
	int i = userRepository.updateUserPassword(password, user.getId());
	if (i < 1) {
	    return "NO";
	}
	return "OK";
    }

}
