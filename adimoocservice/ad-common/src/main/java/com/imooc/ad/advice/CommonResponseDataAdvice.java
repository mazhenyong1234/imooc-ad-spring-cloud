package com.imooc.ad.advice;/*
author:ma
*/

import com.imooc.ad.annotation.IgnoreResponseAdvice;
import com.imooc.ad.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice {
    @Override
    //是否响应拦截是否支持拦截 根据响应条件去判断
    @SuppressWarnings("all")
    public boolean supports(MethodParameter methodParameter,
                            Class aClass) {

        /*对于类上注解了commonresponseadvice 和方法上注解了*/
        if(methodParameter.getDeclaringClass().isAnnotationPresent(
                IgnoreResponseAdvice.class
        )){
            return false;
        }

        /**/
        if(methodParameter.getMethod().isAnnotationPresent(
             IgnoreResponseAdvice.class
        )){
            return false;
        }

        return false;
    }

    @Nullable
    @Override
    //
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter,
                                  MediaType mediaType, Class aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {

        /*实现commonresponse 对象拦截
        * 将body 包装成commonresponse的过程。
        * */
        CommonResponse<Object>response = new CommonResponse<>(0,"");
        if(null== o) {
            return response;
        }
       else if(o instanceof CommonResponse){
           response= (CommonResponse<Object>) o;
        }
       else{
           response.setData(o);
        }

        return response;
    }
}
