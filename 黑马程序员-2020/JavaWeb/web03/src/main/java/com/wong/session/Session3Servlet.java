package com.wong.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * session域对象的ID值
 * 唯一性（在一个Tomcat服务器中，开启，不能关闭）
 * session对象方法 getId()返回值是String
 */
@WebServlet(urlPatterns = "/session3")
public class Session3Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getSession().getId();
        System.out.println(id);
        System.out.println(id.length());
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
