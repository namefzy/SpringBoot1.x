package com.example.demo.data_jpa.web;

import com.example.demo.data_jpa.Dao.UserRepository;
import com.example.demo.data_jpa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/jpa")
public class JpaController {
    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "selectByName")
    public User findByName(){
        User user = userRepository.findByName("1");
        return user;
    }
}
