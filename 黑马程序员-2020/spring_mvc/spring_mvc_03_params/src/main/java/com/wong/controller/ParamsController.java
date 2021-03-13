package com.wong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class ParamsController {
    /**
     * 用法1：多个URL路径映射到同一个Handler（同一个方法）
     */
    @RequestMapping(value = { "gotoResultURL1", "gotoResultURL2" })
    public ModelAndView gotoParams(HttpServletRequest request,
                                   HttpServletResponse response,
                                   HttpSession session,
                                   ModelAndView modelAndView) {
        //封装数据
        modelAndView.addObject("nowDate", new Date() + "==Default==gotoResultURL");
        //指定页面
        modelAndView.setViewName("result");
        return modelAndView;
    }
}
