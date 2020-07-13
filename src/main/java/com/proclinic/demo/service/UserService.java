package com.proclinic.demo.service;

import java.util.List;

import com.proclinic.demo.entity.Department;
import com.proclinic.demo.entity.User;

public interface UserService {
    public String register(User user);

    public String selname(int id);

    public List<Department> selde(int id);

    public String check(String username, String email);

    public String reset(User user);

    public String change(String password);
}
