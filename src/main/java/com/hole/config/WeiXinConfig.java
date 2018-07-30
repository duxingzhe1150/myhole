package com.hole.config;

/**
 * @Author wangcj
 * @date 2018/5/4 11:02
 * @desc 存放微信静态配置信息
 * @since 1.0
 */
public class WeiXinConfig {

    public static class AppConfig {

        public static final String APP_ID = "wxea30003bd18c17e7";

        public static final String APP_SECRET = "649413a99959f419b6b2f0b808605d96";

    }

    //微信API配置
    public static class WeiXinApi{

        public static final String LOGIN_API = "https://api.weixin.qq.com/sns/jscode2session?appid=wxea30003bd18c17e7&secret=649413a99959f419b6b2f0b808605d96&grant_type=authorization_code&js_code=";
    }

    //用户状态配置
    public static class UserStatus{

        public static final Integer ON_LINE = 1;

        public static final Integer PRE_OFF_LINE = 2;
    }

    public static class IsDel{
        public static final Integer YES = 1;

        public static final Integer NO = 0;
    }

}
