package com.hole.controller;

import com.hole.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wangcj
 * @date 2018/5/1 11:33
 * @desc
 * @since 1.0
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("login")
    public void register(@RequestBody User user){



    }


}
