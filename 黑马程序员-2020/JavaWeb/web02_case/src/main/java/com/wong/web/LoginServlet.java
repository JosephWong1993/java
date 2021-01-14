package com.wong.web;

import com.wong.pojo.User;
import com.wong.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 客户端登录请求的Servlet
 * 1：获取客户端提交参数，用户名 密码
 * 2：调用业务层的方法，传递用户名，密码
 * 3：获取业务层返回的查询结果集 User对象
 * 4：判断User对象
 * == null 登录失败的响应
 * != null 登录成功的响应
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1：获取客户端提交参数，用户名 密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //2：调用业务层的方法，传递用户名，密码
        UserService userService = new UserService();
        User user = userService.login(username, password);
        if (user == null) {
            //登录失败的响应
            //响应的页面，还是登录页面
            String message = "用户名或者密码错误"; //提示信息，显示在客户端浏览器上
            //数据存到request域中
            request.setAttribute("message", message);
            //响应回原来的登录页面，重定向还是转发
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            //登录成功的响应
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }
}
