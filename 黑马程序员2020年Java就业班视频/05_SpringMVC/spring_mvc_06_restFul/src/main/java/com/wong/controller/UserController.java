package com.wong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * 控制器（理解为 相当于 WEB 阶段的 Servlet）
 */
@RestController
public class UserController {
    /**
     * 查询
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String gotoResultGet(@PathVariable("id") Integer ids, ModelMap modelMap) {
        //封装数据
        //modelMap.addAttribute("nowDate", new Date() + "===" + ids + "===查询，GET");
        System.out.println("GET ids = " + ids);
        return "result";
    }

    /**
     * 新增
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
    public String gotoResultPost(@PathVariable("id") Integer ids, ModelMap modelMap) {
        System.out.println("POST ids=" + ids);
        return "result";
    }

    /**
     * 更新
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public String gotoResultPut(@PathVariable("id") Integer ids, ModelMap modelMap) {
        System.out.println("PUT ids=" + ids);
        return "result";
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String gotoResultDelete(@PathVariable("id") Integer ids, ModelMap modelMap) {
        System.out.println("DELETE ids=" + ids);
        return "result";
    }
}