package com.hole.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author wangcj
 * @date 2018/5/1 12:04
 * @desc 数据统一返回格式
 * @since 1.0
 */
@Getter
@Setter
public class Resp {

    private static String CODE_SUCCESS="2000";
    private static String MESSAGE_SUCCESS="success";

    private String code;

    private String message;

    private Object data;

    private Resp(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Resp error(String code, String message, Object data){
        return new Resp(code,message,data);
    }

    public static Resp success(Object data){
        return error(CODE_SUCCESS,MESSAGE_SUCCESS,data);
    }

    public static Resp success(String message){

        return error(CODE_SUCCESS,message,null);
    }

    public static Resp success(){
        return success(null);
    }

    public static Resp error(String code, String message){
        return error(code,message,null);
    }

    @Override
    public String toString() {
        return "Resp{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
