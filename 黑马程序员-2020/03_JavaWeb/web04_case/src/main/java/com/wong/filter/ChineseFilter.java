package com.wong.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 中文乱码处理过滤器
 */
@WebFilter(urlPatterns = "/*")
public class ChineseFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    
    }
    
    /**
     * 每次拦截执行的方法
     * 方法的参数 ServletRequest，ServletResponse 传递到Servlet的doGet方法
     * 过滤器中，设置request对象使用编码表
     * 所有的Servlet都收益
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        chain.doFilter(request, response);
    }
    
    @Override
    public void destroy() {
    
    }
}
