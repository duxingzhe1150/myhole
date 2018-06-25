package com.hole.service;

import com.google.gson.Gson;
import com.hole.config.CacheConfig;
import com.hole.config.WeiXinConfig;
import com.hole.dao.UserDao;
import com.hole.entity.Resp;
import com.hole.entity.User;
import com.hole.entity.WeiXinLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author wangcj
 * @date 2018/5/22 15:29
 * @desc
 * @since 1.0
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RestTemplate restTemplate;

    public Resp autoRegister(String code){

        ResponseEntity<String> resp = restTemplate.getForEntity(WeiXinConfig.WeiXinApi.LOGIN_API+code, String.class);

        String result = resp.getBody();

        Gson gson = new Gson();

        WeiXinLogin weiXinLogin = gson.fromJson(result, WeiXinLogin.class);

        String openID=weiXinLogin.getOpenid();

        User user = userDao.findByWeiXinID(openID);

        if (user == null){

            user = new User();

            user.setWeiXinID(openID);

            user = userDao.save(user);
        }

        CacheConfig.sessionMap.put(weiXinLogin.getSession_key(),user);
        CacheConfig.sessionHeart.put(weiXinLogin.getSession_key(),WeiXinConfig.UserStatus.ON_LINE);


        return Resp.success(result);
    }
}
