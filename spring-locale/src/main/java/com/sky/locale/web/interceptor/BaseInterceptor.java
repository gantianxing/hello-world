package com.sky.locale.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 保留 前处理方法 拦截器
 * Created by gantianxing on 2017/6/5.
 */
public abstract class BaseInterceptor implements HandlerInterceptor {

    public abstract boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception;

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     * 判断是否是Ajax请求
     * @param request
     * @return
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String requestType = request.getHeader("x-requested-with");
        return requestType != null && "XMLHttpRequest".equalsIgnoreCase(requestType);
    }

}
