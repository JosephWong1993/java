package com.wong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 控制器（理解为 相当于 WEB 阶段的 Servlet）
 */
@Controller
@RequestMapping("default")
public class DefaultController {
    
    /**
     * @param model 接口，提供了向Request域 封装数据的操作
     * @return 指定的页面路径
     */
    @RequestMapping("gotoResultModel")
    public String gotoResultModel(Model model) {
        //抛异常
        List<String> list = null;
        System.out.println("list = " + list.size()); //空指针异常
        
        //封装数据
        model.addAttribute("nowDate", new Date() + "===gotoResultModel");
        //指定页面
        return "result";
    }
    
    /**
     * @param modelMap 实现类，提供了向Request域 封装数据的操作
     * @return 指定的页面路径
     */
    @RequestMapping("gotoResultModelMap")
    public String gotoResultModelMap(ModelMap modelMap) {
        //抛异常
        int[] arr = new int[0];
        System.out.println("arr = " + arr[5]); //数组角标越界异常
        
        //封装数据
        //        modelMap.addAttribute("nowDate", new Date() + "===gotoResultModelMap");
        System.out.println("gotoResultModelMap方法执行了");
        //指定页面
        return "result";
    }
    
    /**
     * 返回值为void类型，使用Request对象 实现页面跳转（注意：无法将SpringMVC 提供的 Model，ModelMap封装的数据 请求转发到目标页面）
     *
     * @param modelMap
     */
    @RequestMapping("gotoResultRequest")
    public void gotoResultRequest(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
            throws ServletException, IOException {
        //通过SpringMVC框架封装数据到Request域中（跳转页面的方式必须采用的是SpringMVC框架提交的方式，才能把数据传递过去）
        modelMap.addAttribute("nowDate", new Date() + "===gotoResultRequest");
        //请求转发
        request.getRequestDispatcher("/default/gotoResultModelMap.do").forward(request, response);
    }
    
    /**
     * 返回值为void类型，使用Response跳转页面（注意：无法将SpringMVC 提供的 Model，ModelMap封装的数据 重定向到目标页面）
     *
     * @param modelMap
     */
    @RequestMapping("gotoResultResponse")
    public void gotoResultResponse(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
            throws ServletException, IOException {
        //通过SpringMVC框架封装数据到Request域中（跳转页面的方式必须采用的是SpringMVC框架提交的方式，才能把数据传递过去）
        modelMap.addAttribute("nowDate", new Date() + "===gotoResultResponse");
        //指定页面
        //重定向
        response.sendRedirect(request.getContextPath() + "/default/gotoResultModelMap.do");
    }
    
    /**
     * 返回值为String类型，通过SpringMVC框架 使用请求转发 实现页面跳转（注意：可以将SpringMVC 提供的 Model，ModelMap封装的数据 请求转发到目标页面）
     * <p>
     * 格式用法：forward:请求的地址
     *
     * @param modelMap
     */
    @RequestMapping("gotoResultForward")
    public String gotoResultForward(ModelMap modelMap) throws ServletException, IOException {
        //通过SpringMVC框架封装数据到Request域中（跳转页面的方式必须采用的是SpringMVC框架提交的方式，才能把数据传递过去）
        modelMap.addAttribute("nowDate", new Date() + "===gotoResultForward");
        //指定页面
        //请求转发
        return "forward:/default/gotoResultModelMap.do";
    }
    
    /**
     * 返回值为String类型，通过SpringMVC框架 使用重定向 实现页面跳转（注意：不可以将SpringMVC 提供的 Model，ModelMap封装的数据 请求转发到目标页面）
     * <p>
     * 格式用法：redirect:请求的地址
     *
     * @param modelMap
     */
    @RequestMapping("gotoResultRedirect")
    public String gotoResultRedirect(ModelMap modelMap) throws ServletException, IOException {
        //通过SpringMVC框架封装数据到Request域中（跳转页面的方式必须采用的是SpringMVC框架提交的方式，才能把数据传递过去）
        modelMap.addAttribute("nowDate", new Date() + "===gotoResultRedirect");
        //指定页面
        //请求转发
        return "redirect:/default/gotoResultModelMap.do";
    }
}
