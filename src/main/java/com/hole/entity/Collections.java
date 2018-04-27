package com.hole.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author wangcj
 * @date 2018/4/27 9:42
 * @desc
 * @since 1.0
 */
@Entity
@Getter
@Setter
public class Collections {

    @Id()
    @GeneratedValue
    private Integer id;  //收藏id

    private Integer secretId;  //秘密id

    private Integer userId;  //用户id

    @Column(length = 50)
    private String groupCode;  //分组编号

    @Column(length = 50)
    private String groupName;  //分组名

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;  //收藏时间

    @Override
    public String toString() {
        return "Collections{" +
                "id=" + id +
                ", secretId=" + secretId +
                ", userId=" + userId +
                ", groupCode='" + groupCode + '\'' +
                ", groupName='" + groupName + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
