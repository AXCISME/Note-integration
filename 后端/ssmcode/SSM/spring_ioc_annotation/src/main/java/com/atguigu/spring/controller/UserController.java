package com.atguigu.spring.controller;

import com.atguigu.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.lang.reflect.Parameter;

//@Controller("controller")
@Controller
public class UserController {
    @Autowired
    @Qualifier("")
    private UserService userService;

    public void saveUser(){
        userService.saveUser();
    }
}
