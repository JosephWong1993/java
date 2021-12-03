package com.wong.code;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(urlPatterns = "/checkCode")
public class CheckCodeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         * 进行验证码的校验
         * 客户端提交验证码，获取request.getParameter() == 字符串
         * 从session域中，获取验证码
         */
        String code = request.getParameter("code");
        //session域中，取出验证码
        String session_code = (String) request.getSession().getAttribute("code");
        if (code.equalsIgnoreCase(session_code)) {
            response.getWriter().write("code OK");
        } else {
            response.getWriter().write("code NO OK");
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
