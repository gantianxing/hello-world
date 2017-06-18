package com.sky.locale.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by gantianxing on 2017/6/5.
 */
public class LoginInterceptor extends BaseInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器 pre方法");
        return true;
    }
}
