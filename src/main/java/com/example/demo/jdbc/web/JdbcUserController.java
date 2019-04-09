package com.example.demo.jdbc.web;

import com.example.demo.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/jdbc")
public class JdbcUserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/create")
    public void create(){
        userService.create("1",1);
    }
}
