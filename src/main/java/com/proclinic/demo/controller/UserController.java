package com.proclinic.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proclinic.demo.entity.User;
import com.proclinic.demo.service.UserService;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public String register(User user) {
	user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
	return userService.register(user);
    }
}
