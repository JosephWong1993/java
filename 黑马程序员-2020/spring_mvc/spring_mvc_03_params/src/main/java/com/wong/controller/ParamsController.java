package com.wong.controller;

import com.wong.pojo.QueryVO;
import com.wong.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping(value = "params")
public class ParamsController {
    /**
     * 功能1：默认支持ServletAPI
     */
    @RequestMapping(value = { "gotoParams" })
    public ModelAndView gotoParams(HttpServletRequest request,
                                   HttpServletResponse response,
                                   HttpSession session,
                                   ModelAndView modelAndView) {
        //获取请求参数
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        //封装数据
        modelAndView.addObject("nowDate", new Date() + "==" + id + "==" + name);
        //指定页面
        modelAndView.setViewName("result");
        return modelAndView;
    }
    
    /**
     * 功能2：绑定简单的数据类型
     */
    @RequestMapping(value = { "gotoParamsBase" })
    public ModelAndView gotoParamsBase(Boolean isVIP, ModelAndView modelAndView) {
        //封装数据
        modelAndView.addObject("nowDate", new Date() + "==" + isVIP);
        //指定页面
        modelAndView.setViewName("result");
        return modelAndView;
    }
    
    /**
     * 功能3：@RequestParam注解使用
     */
    @RequestMapping(value = { "gotoParamsRequestParam" })
    public ModelAndView gotoParamsRequestParam(@RequestParam("id") Integer ids, ModelAndView modelAndView) {
        //封装数据
        modelAndView.addObject("nowDate", new Date() + "==" + ids);
        //指定页面
        modelAndView.setViewName("result");
        return modelAndView;
    }
    
    /**
     * 功能4：绑定pojo对象
     */
    @RequestMapping(value = { "gotoParamsPojo" })
    public ModelAndView gotoParamsPojo(User user, ModelAndView modelAndView) {
        //封装数据
        modelAndView.addObject("nowDate", new Date() + "==" + user);
        //指定页面
        modelAndView.setViewName("result");
        return modelAndView;
    }
    
    /**
     * 功能5：绑定pojo对象的包装对象
     */
    @RequestMapping(value = { "gotoParamsQueryVO" })
    public ModelAndView gotoParamsQueryVO(QueryVO queryVO, ModelAndView modelAndView) {
        //封装数据
        modelAndView.addObject("nowDate", new Date() + "==" + queryVO);
        //指定页面
        modelAndView.setViewName("result");
        return modelAndView;
    }
    
    /**
     * 功能6：绑定List集合包装pojo对象
     */
    @RequestMapping(value = { "gotoParamsList" })
    public ModelAndView gotoParamsList(QueryVO queryVO, ModelAndView modelAndView) {
        //封装数据
        modelAndView.addObject("nowDate", new Date() + "==" + queryVO);
        //指定页面
        modelAndView.setViewName("result");
        return modelAndView;
    }
    
    /**
     * 功能7：绑定Map集合包装pojo对象
     */
    @RequestMapping(value = { "gotoParamsMap" })
    public ModelAndView gotoParamsMap(QueryVO queryVO, ModelAndView modelAndView) {
        //封装数据
        modelAndView.addObject("nowDate", new Date() + "==" + queryVO);
        //指定页面
        modelAndView.setViewName("result");
        return modelAndView;
    }
}