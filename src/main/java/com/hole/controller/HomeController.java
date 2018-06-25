package com.hole.controller;

import com.google.gson.JsonObject;
import com.hole.config.WeiXinConfig;
import com.hole.entity.Resp;
import com.hole.entity.User;
import com.hole.service.SecretsService;
import com.hole.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private UserService userService;

    @Autowired
    private SecretsService secretsService;

    @RequestMapping("register")
    public void register(@RequestBody User user){



    }

    @RequestMapping("login")
    public Resp login(String code){

        return userService.autoRegister(code);
    }

    @RequestMapping("index")
    public Resp home(){

        return secretsService.getHomeList();
    }


}
