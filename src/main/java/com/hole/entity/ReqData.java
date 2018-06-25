package com.hole.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author wangcj
 * @date 2018/5/24 17:01
 * @desc
 * @since 1.0
 */
@Getter
@Setter
public class ReqData<T> {

    private String session_key;

    private String versionCode;

    private T data;
}
