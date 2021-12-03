package com.wong.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 过滤器的快速入门
 * 1：定义类实现接口 Filter
 * 2：重写接口中的抽象方法
 * 3：web.xml配置
 * <p>
 * 过滤器对象的生命周期
 * 1：对象初始化创建，调用方法init
 * 方法参数 FilterConfig
 * Tomcat引擎创建过滤器对象，并调用方法init传递参数
 * Tomcat启动的时候，创建过滤器对象
 * <p>
 * 方法参数 FilterConfig，过滤器配置对象
 * 可以获取到过滤器的名字等待
 * 方法：getServletContext()获取到最大的域对象
 * <p>
 * 2：拦截方法 doFilter
 * 每次访问要拦截的对象，就运行
 * 访问了非拦截对象，不运行
 * <p>
 * 3：对象销毁方法 destroy()
 * 关闭服务器的时候，过滤器对象销毁
 * web项目，从服务器中移除
 */
public class MyFilter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器对象被创建");
        ServletContext servletContext = filterConfig.getServletContext();
        System.out.println(servletContext);
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("我是过滤器1");
        //        response = null;
        //放行s
        chain.doFilter(request, response);
    }
    
    @Override
    public void destroy() {
        System.out.println("过滤器对象被销毁");
    }
}
