package com.wong.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 过滤器的快速入门
 * 1：定义类实现接口 Filter
 * 2：重写接口中的抽象方法
 * 3：web.xml配置
 */
public class MyFilter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        //放行
        chain.doFilter(request, response);
    }
    
    @Override
    public void destroy() {
    
    }
}
