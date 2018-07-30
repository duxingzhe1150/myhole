package com.hole.aspect;

import com.google.gson.Gson;
import com.hole.config.CacheConfig;
import com.hole.config.WeiXinConfig;
import com.hole.entity.ReqData;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


/**
 * 控制层的切面拦截
 * Created by Administrator on 2017/7/14 0014.
 */
@Aspect
@Component
public class WebControllerAOP {

    private static final Logger logger = LoggerFactory.getLogger(WebControllerAOP.class);


    //匹配com.example.demo.controller包及其子包下的所有类的所有方法
    @Pointcut("execution(* com.hole.controller..*.*(..))")
    public void executeService(){

    }

    @Around("executeService()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        Long start=System.currentTimeMillis();
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        Object[] args=pjp.getArgs(); //参数列表
        Gson gson=new Gson();

        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        logger.info("请求开始, 各个参数, ip:{}, url: {}, method: {}, uri: {},参数列表：{}",
                request.getRemoteAddr(), url, method, uri,Arrays.toString(args));

        Object result = pjp.proceed();
        Long end=System.currentTimeMillis();

        Long total = end-start;
        logger.info("请求结束，controller的返回值是:{},请求耗时：{}" , gson.toJson(result) , total);
        return result;
    }

//    @Around("executeService()")
    public Object permissionAspect(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args=pjp.getArgs(); //参数列表

        Object result = pjp.proceed();

        for (int i = 0; i < args.length; i++) {

            if (args[i] instanceof ReqData){

                ReqData reqData = (ReqData) args[i];

                String session_key = reqData.getSession_key();

                if (CacheConfig.sessionHeart.containsKey(session_key)){

                    CacheConfig.sessionHeart.put(session_key,WeiXinConfig.UserStatus.ON_LINE);

                    return result;

                }

            }

        }

        return result;
    }

}
