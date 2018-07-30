package com.hole.controller;

import com.hole.entity.*;
import com.hole.service.CommentsService;
import com.hole.service.LikesService;
import com.hole.service.SecretsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.FormSubmitEvent;

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

    @Autowired
    private LikesService likesService;

    @Autowired
    private CommentsService commentsService;


    @RequestMapping(path = "saveSecret",method = RequestMethod.POST)
    public Resp saveSecret(ReqData<Secrets> reqData){

        return secretsService.saveSecret(reqData);
    }

    @RequestMapping(path = "mySecrets",method = RequestMethod.GET)
    public Resp mySecrets(@PathVariable Integer userId){

        return secretsService.querySecretByUserId(userId);
    }

    @RequestMapping(path = "queryOneSecret",method = RequestMethod.GET)
    public Resp queryOneSecret(@PathVariable Integer id){

        return Resp.success(secretsService.queryOneSecretById(id));
    }

    @RequestMapping(path = "likeSecret",method = RequestMethod.POST)
    public Resp likeSecret(Likes likes){

        return likesService.likeOneSecret(likes);
    }

    @RequestMapping(path = "addComment",method = RequestMethod.POST)
    public Resp addComment(Comments comments){

        return commentsService.addComment(comments);
    }

    @RequestMapping(path = "queryComments",method = RequestMethod.GET)
    public Resp queryComments(@PathVariable Integer secretId){

        return commentsService.queryCommentsBySecretId(secretId);
    }



}
