package com.hole.controller;

import com.hole.entity.ReqData;
import com.hole.entity.Resp;
import com.hole.entity.Secrets;
import com.hole.service.SecretsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wangcj
 * @date 2018/5/24 19:27
 * @desc
 * @since 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SecretsService secretsService;

    public Resp saveSecret(ReqData<Secrets> reqData){

        return secretsService.saveSecret(reqData);
    }

}
