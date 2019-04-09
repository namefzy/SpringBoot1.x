package com.example.demo.web;

import com.example.demo.exceptionHandler.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String index()throws Exception{
        throw new Exception("发生错误");
    }

    @RequestMapping(value = "/json",method = RequestMethod.POST)
    public String josn()throws Exception{
        throw new MyException("发生错误");
    }
    @RequestMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://blog.didispace.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }

}
