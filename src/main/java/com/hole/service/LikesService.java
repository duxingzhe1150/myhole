package com.hole.service;

import com.hole.dao.LikesDao;
import com.hole.entity.Likes;
import com.hole.entity.Resp;
import com.hole.entity.Secrets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author wangcj
 * @date 2018/7/26 14:43
 * @desc
 * @since 1.0
 */
@Service
public class LikesService {

    @Autowired
    LikesDao likesDao;

    @Autowired
    SecretsService secretsService;

    public Resp likeOneSecret(Likes like){

        if (like == null){
            return Resp.error("400","参数错误");
        }
        Secrets secrets = secretsService.queryOneSecretById(like.getSecretId());

        secrets.setLikesCount(secrets.getLikesCount()+1);

        like.setCreateTime(new Date());

        secretsService.updateSecretById(secrets);
        likesDao.save(like);

        return Resp.success();
    }

}
