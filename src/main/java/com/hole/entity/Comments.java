package com.hole.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author wangcj
 * @date 2018/4/27 9:28
 * @desc 评论实体类
 * @since 1.0
 */
@Entity
@Getter
@Setter
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  //评论id

    private Integer userId;  //评论者id

    private Integer secretId;  //秘密id

    private String content;  //内容 使用默认长度255

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;  //创建时间

    @Column(length = 2)
    private Integer isDel;  //是否删除

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", userId=" + userId +
                ", secretId=" + secretId +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", isDel=" + isDel +
                '}';
    }
}
