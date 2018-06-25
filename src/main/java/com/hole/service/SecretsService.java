package com.hole.service;

import com.hole.dao.SecretsDao;
import com.hole.entity.ReqData;
import com.hole.entity.Resp;
import com.hole.entity.Secrets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author wangcj
 * @date 2018/5/24 15:29
 * @desc
 * @since 1.0
 */
@Service
public class SecretsService {
    @Autowired
    private SecretsDao secretsDao;

    public Resp getHomeList(){

        List<Secrets> secretsList = secretsDao.findByIsDelOrderByCreateTimeDesc(0);

        return Resp.success(secretsList);
    }

    public Resp saveSecret(ReqData<Secrets> reqData){

        Secrets secrets = reqData.getData();

        secretsDao.save(secrets);

        return Resp.success();
    }
}
