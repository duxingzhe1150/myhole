package com.hole.config;

import com.hole.entity.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wangcj
 * @date 2018/5/22 19:16
 * @desc
 * @since 1.0
 */
public class CacheConfig {

    public static final Map<String,User> sessionMap = new HashMap<>();

    public static final Map<String,Integer> sessionHeart =new HashMap<>();

}
