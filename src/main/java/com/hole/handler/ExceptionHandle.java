package com.hole.handler;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Created by Administrator on 2017/7/18 0018.
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map globalExceptionHandeler(Exception e, HttpServletResponse response){

        Map<String,Object> result=new HashMap<>();
        result.put("errcode",201);

        result.put("errmsg",e.getMessage());

        return result;

    }


}
