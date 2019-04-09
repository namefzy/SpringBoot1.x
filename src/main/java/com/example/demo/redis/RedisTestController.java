package com.example.demo.redis;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedisTestController {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private RedisTemplate<String, RedisUser> template;
    @RequestMapping("/redis")
    public String test(){
        redisTemplate.opsForValue().set("ccc","111");
        Assert.assertEquals("111",redisTemplate.opsForValue().get("aaa"));
        return "index";
    }
    @RequestMapping("/objectSerializer")
    public void objectSerializer(){
        RedisUser user = new RedisUser("超人",20);
        template.opsForValue().set(user.getUsername(),user);
    }
}
