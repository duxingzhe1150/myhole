
package com.hole.aspect;

import com.google.gson.Gson;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * service层的切面类，拦截service类中的所有方法并记录日志
 */

@Aspect
@Component
public class ServiceAOP {

    private static final Logger logger= LoggerFactory.getLogger(ServiceAOP.class);

    //拦截service包下的所有类的所有方法
    @Pointcut("execution(* com.hole.service..*.*(..))")
    public void executeService(){
    }


/**
     * 具体拦截方法，拦截指定方法并记录其传入参数、返回值信息
     * @param point
     * @return
     * @throws Throwable
     */

    @Around("executeService()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {

        String className=point.getSignature().getDeclaringTypeName();//类名
        String method=point.getSignature().getName(); //方法名
        Object[] args=point.getArgs(); //参数列表
        Gson gson=new Gson();

        logger.info("操作Service开始, 各个参数, className: {}, method: {}, args: {}",
                        className, method, gson.toJson(args));

        Object result=point.proceed();   //返回值
        logger.info("操作Service结束，Service的返回值是 " + gson.toJson(result));

        return result;
    }


}
