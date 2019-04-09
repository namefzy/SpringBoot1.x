package com.example.demo;

import com.example.demo.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Demo {
    private static Map<String, Object> map1 = new HashMap<String, Object>();
    private static Map<String, Object> map2 = new Hashtable<String, Object>();
    private static Map<String, Object> map3 = new ConcurrentHashMap<String, Object>();
    private static Map<String, Object> map4 = Collections.synchronizedMap(new HashMap<String, Object>());
    @Autowired
    private User user;
    @Test
    public void contextLoads() {
//		Assert.assertEquals(user.getName(),"傅中雨");
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    if (map3.size() > 0) {
                        for (Map.Entry<String, Object> entry : map3.entrySet()) {
                            System.out.println(String.format("%s: %s", entry.getKey(), entry.getValue()));
                        }
                        map3.clear();
                    }
                    try {
                        Thread.sleep((new Random().nextInt(10) + 1) * 1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {

                for (int i = 1; i <= 100; i++) {
                    map3.put("key" + i, "value" + i);
                    try {
                        Thread.sleep((new Random().nextInt(10) + 1) * 1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
