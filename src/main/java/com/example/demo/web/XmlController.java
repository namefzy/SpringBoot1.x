package com.example.demo.web;

import com.example.demo.domain.User1;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * xml参数获取
 */
@Controller
@RequestMapping("/xml")
public class XmlController {

    @PostMapping(value = "/user",consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public User1 create(@RequestBody User1 user) {
        user.setName("didispace.com : " + user.getName());
        user.setAge(user.getAge() + 100);
        return user;
    }

}
