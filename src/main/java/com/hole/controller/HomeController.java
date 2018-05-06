package com.hole.controller;

import com.hole.entity.Resp;
import com.hole.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wangcj
 * @date 2018/5/1 11:33
 * @desc
 * @since 1.0
 */
@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("register")
    public void register(@RequestBody User user){



    }

    @RequestMapping("login")
    public Resp login(String code){

        System.out.println(code);

        Map<String,String> result = new HashMap<>();



        return Resp.success(result);
    }


}
