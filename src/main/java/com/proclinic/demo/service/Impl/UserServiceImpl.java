package com.proclinic.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proclinic.demo.entity.User;
import com.proclinic.demo.repository.UserRepository;
import com.proclinic.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public String register(User user) {
	User findUser = userRepository.findUserByUserName(user.getUsername());
	if (findUser == null) {
	    if (userRepository.save(user) != null) {
		return "OK";
	    }
	    return "NO";
	}
	return "用户名已存在，请登录";
    }

}
