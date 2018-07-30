package com.hole.service;

import com.hole.config.WeiXinConfig;
import com.hole.dao.SecretsDao;
import com.hole.entity.ReqData;
import com.hole.entity.Resp;
import com.hole.entity.Secrets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

        List<Secrets> secretsList = secretsDao.findByIsDelOrderByCreateTimeDesc(WeiXinConfig.IsDel.NO);

        return Resp.success(secretsList);
    }

    public Resp saveSecret(ReqData<Secrets> reqData){

        Secrets secrets = reqData.getData();

        secrets.setCreateTime(new Date());

        secretsDao.save(secrets);

        return Resp.success();
    }

    public Resp querySecretByUserId(Integer userId){

        if (userId == null) {
            return Resp.error("400","参数错误");
        }

        List<Secrets> secretsList = secretsDao.findByUserIdAndIsDel(userId,WeiXinConfig.IsDel.NO);

        return Resp.success(secretsList);
    }

    public Resp updateSecretById(Secrets secrets){

        secretsDao.save(secrets);

        return Resp.success();
    }

    public Secrets queryOneSecretById(Integer id){

        Optional<Secrets> result = secretsDao.findById(id);

        boolean isPresent = result.isPresent();

        if (isPresent)
            return result.get();
        else
            return null;
    }
}
