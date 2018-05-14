package com.hole.aspect;

import com.google.gson.Gson;
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
        logger.info("请求开始, 各个参数, ip:{}, url: {}, method: {}, uri: {}",request.getRemoteAddr(), url, method, uri);

        logger.info("参数列表：{}" , Arrays.toString(args));

        Object result = pjp.proceed();
        Long end=System.currentTimeMillis();

        Long total = end-start;
        logger.info("请求结束，controller的返回值是:{},请求耗时：{}" , gson.toJson(result) , total);
        return result;
    }

}
