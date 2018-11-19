package com.xz.service.frame.spring;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InterceptorDemo  implements HandlerInterceptor{

    ////该方法在进入Handler方法执行之前执行此方法
    //应用场景：如身份认证，身份授权.
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return false;
    }


    //该方法在进入Handler方法之后，返回ModelAndView之前执行
    //应用场景从modelAndView出发，将公用模型数据（如菜单导航）在这里传到视图，也可以在这里统一制定视图
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
    //该方法在handler方法执行完之后执行
    //应用场景：统一日志处理，统一异常处理
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
