package com.hole.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author wangcj
 * @date 2018/4/25 17:15
 * @desc 用户实体
 * @since 1.0
 */
@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  //用户id

    @Column(length = 50)
    private String nickName;  //昵称

    @Column(length = 50)
    private String avatar;  //头像

    @Column(length = 50)
    private String weiXinID;  //微信唯一id

    @Column(length = 10)
    private String sex;  //性别

    @Column(length = 50)
    private String email;  //邮箱

    @Column(length = 30)
    private String userName;  //用户名

    @Column(length = 30)
    private String passWorld;  //密码

    @Temporal(TemporalType.TIMESTAMP)
    private Date registration;  //注册时间

    @Temporal(TemporalType.TIMESTAMP)
    private Date recentlyLogged;  //最近登录时间

    @Column(length = 100)
    private String recentlyLocation;  //最近位置

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", weiXinID='" + weiXinID + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", passWorld='" + passWorld + '\'' +
                ", registration=" + registration +
                ", recentlyLogged=" + recentlyLogged +
                ", recentlyLocation='" + recentlyLocation + '\'' +
                '}';
    }
}
