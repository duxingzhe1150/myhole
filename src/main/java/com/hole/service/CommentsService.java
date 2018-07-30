package com.hole.service;

import com.hole.config.WeiXinConfig;
import com.hole.dao.CommentsDao;
import com.hole.entity.Comments;
import com.hole.entity.Resp;
import com.hole.entity.Secrets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author wangcj
 * @date 2018/7/26 17:16
 * @desc
 * @since 1.0
 */
@Service
public class CommentsService {

    @Autowired
    CommentsDao commentsDao;

    @Autowired
    SecretsService secretsService;

    public Resp addComment(Comments comment){

        if (comment == null)
            return Resp.error("400","参数错误");

        Secrets secret = secretsService.queryOneSecretById(comment.getSecretId());

        secret.setCommentsCount(secret.getCommentsCount()+1);

        comment.setCreateTime(new Date());

        secretsService.updateSecretById(secret);
        commentsDao.save(comment);

        return Resp.success();
    }

    public Resp queryCommentsBySecretId(Integer secretId){

        List<Comments> result = commentsDao.findBySecretIdAndIsDelOrderByCreateTimeAsc(secretId,WeiXinConfig.IsDel.NO);

        return Resp.success(result);
    }

}
