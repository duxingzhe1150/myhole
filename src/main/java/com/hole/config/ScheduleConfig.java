package com.hole.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @Author wangcj
 * @date 2018/5/22 19:27
 * @desc
 * @since 1.0
 */
@Configuration
public class ScheduleConfig {


    /*
    * 清除五分钟内没有访问过的session
    * */
//    @Scheduled(fixedDelay = 60*1000*5)
    public void sessionClear(){

        for (String session : CacheConfig.sessionHeart.keySet()){
            if (CacheConfig.sessionHeart.get(session).equals(WeiXinConfig.UserStatus.ON_LINE)){
                CacheConfig.sessionHeart.put(session,WeiXinConfig.UserStatus.PRE_OFF_LINE);
            }else if (CacheConfig.sessionHeart.get(session).equals(WeiXinConfig.UserStatus.PRE_OFF_LINE)){

                CacheConfig.sessionHeart.remove(session);
                CacheConfig.sessionMap.remove(session);
            }
        }
    }


}
