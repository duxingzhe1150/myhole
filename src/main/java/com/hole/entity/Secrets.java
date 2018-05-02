package com.hole.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author wangcj
 * @date 2018/4/26 18:25
 * @desc 秘密实体类
 * @since 1.0
 */
@Entity
@Getter
@Setter
public class Secrets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  //秘密id

    private Integer userId;  //用户id

    private String content;  //内容 默认长度255

    private String labels;  //标签 默认长度255

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;  //创建时间

    private Integer likesCount;  //赞的数量

    private Integer commentsCount;  //评论数量

    @Column(length = 2)
    private Integer isAllowComment; //是否允许评论

    @Column(length = 2)
    private Integer isDel;   //是否已删除

    @Override
    public String toString() {
        return "Secrets{" +
                "id=" + id +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", labels='" + labels + '\'' +
                ", createTime=" + createTime +
                ", likesCount=" + likesCount +
                ", commentsCount=" + commentsCount +
                ", isAllowComment=" + isAllowComment +
                ", isDel=" + isDel +
                '}';
    }
}
