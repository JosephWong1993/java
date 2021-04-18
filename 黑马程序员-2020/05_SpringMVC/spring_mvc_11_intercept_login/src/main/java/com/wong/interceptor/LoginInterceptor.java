package com.wong.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户登录的拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    
    /**
     * 首先判断是否登录了，如果登录了，放行，如果没有登录，跳转到登录页面
     * 细节：
     * 判断是否是登录请求，如果是登录请求，放行
     * 如果不是登录请求： 判断session中是否存储了用户信息
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        //1.获取当前拦截的请求信息
        String requestURI = request.getRequestURI();
        System.out.println("requestURI = " + requestURI);
        //2.如果当前请求是 登录请求，拦截器放行，可以登录
        if ((request.getContextPath() + "/default/login.do").equals(requestURI)) {
            return true;
        }
        //3.如果当前用户 已经登录，用户执行的操作 都放行
        //根据Session域中的用户是否为null，来判断是否已登录
        Object username = request.getSession().getAttribute("username");
        if (username == null) {
            //用户未登录，本次请求不放行，跳转到登录页面
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return false;
        } else {
            //用户已登录，放行请求，正常执行
            return true;
        }
    }
}