package com.proclinic.demo.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proclinic.demo.entity.User;
import com.proclinic.demo.service.UserService;

@RestController
public class UserController {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    UserService userService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @PostMapping("/register")
    public String register(@RequestBody User user) {
	user.setPassword(encoder.encode(user.getPassword()));
	return userService.register(user);
    }

    @GetMapping("/email")
    public String email(@RequestParam String email) {
	//生成验证码
	StringBuilder checkCode = new StringBuilder();
	Random random = new Random();
	for (int i = 0; i <= 5; i++) {
	    checkCode.append(random.nextInt(10));
	}

	//发送邮件
	SimpleMailMessage message = new SimpleMailMessage();
	message.setFrom("xox.zhe@qq.com");
	message.setTo(email);
	message.setSubject("来自ProClinic的验证码");
	message.setText("验证码为：" + checkCode.toString() + "，打死也不要告诉别人！");
	javaMailSender.send(message);
	return checkCode.toString();
    }

    @PostMapping("/change")
    public String change(@RequestBody User user) {
	return userService.change(encoder.encode(user.getPassword()));
    }

    @GetMapping("/check")
    public String check(@RequestParam String username, @RequestParam String email) {
	return userService.check(username, email);
    }

    @PostMapping("/reset")
    public String reset(@RequestBody User user) {
	user.setPassword(encoder.encode(user.getPassword()));
	return userService.reset(user);
    }
}
