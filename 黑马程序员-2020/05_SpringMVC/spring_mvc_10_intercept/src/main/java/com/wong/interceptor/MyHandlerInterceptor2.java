package com.wong.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHandlerInterceptor2 implements HandlerInterceptor {
    /**
     * 在Controller控制器中的Handler方法执行之前：执行
     *
     * @param request
     * @param response
     * @param handler
     * @return true：执行后续的请求（情况一：执行后续的其他拦截器；情况二：所有的拦截器都执行完毕并放行，执行Handler方法）；false：后续的请求代码不再执行（拦截住了）
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("preHandle 执行了 2");
        return false;
    }
    
    /**
     * handler逻辑真正执行完成但尚未返回页面
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle 执行了 2");
    }
    
    /**
     * 返回页面之后
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("afterCompletion 执行了 2");
    }
}
