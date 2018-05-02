package com.hole.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author wangcj
 * @date 2018/4/26 18:34
 * @desc 赞的实体类
 * @since 1.0
 */
@Entity
@Getter
@Setter
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  //赞id

    private Integer secretId;  //秘密id

    private Integer userId;  //评论者id

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;  //创建时间

    @Override
    public String toString() {
        return "Likes{" +
                "id=" + id +
                ", secretId=" + secretId +
                ", userId=" + userId +
                ", createTime=" + createTime +
                '}';
    }
}
