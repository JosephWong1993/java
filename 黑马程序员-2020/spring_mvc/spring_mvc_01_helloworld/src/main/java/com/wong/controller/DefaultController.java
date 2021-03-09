package com.wong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * 控制器（理解为 相当于 WEB 阶段的 Servlet）
 */
@Controller
public class DefaultController {
    /**
     * 定义方法：相当于以前 Servlet中用于处理请求的方法
     */
    @RequestMapping("gotoResult")
    public ModelAndView gotoResult(ModelAndView modelAndView) {
        //封装数据
        modelAndView.addObject("nowDate", new Date());
        //指定页面
        modelAndView.setViewName("WEB-INF/jsp/result.jsp");
        
        return modelAndView;
    }
}
