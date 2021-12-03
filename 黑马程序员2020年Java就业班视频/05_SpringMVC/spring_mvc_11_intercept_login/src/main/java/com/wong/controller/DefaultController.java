package com.wong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 控制器（理解为 相当于 WEB 阶段的 Servlet）
 */
@RequestMapping("default")
@Controller
public class DefaultController {
    /**
     * 定义方法：相当于以前 Servlet中用于处理请求的方法
     */
    @RequestMapping("login")
    public String gotoResult(String username, String password, HttpServletRequest request) {
        //如果账号为Z3,密码123，认为账号密码正确，可以登录，否则不能登录
        if ("Z3".equals(username) && "123".equals(password)) {
            //把当前登录的账户名存到Session域中
            request.getSession().setAttribute("username", username);
            
            //登录成功，跳转到查询所有账户信息的页面
            return "redirect:/account/findAll.do";
        } else {
            //登录失败（返回到 输入用户名密码的 登录页面）
            return "redirect:/index.jsp";
        }
    }
}