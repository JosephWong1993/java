package com.wong.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wong.entity.Result;
import com.wong.pojo.CheckItem;
import com.wong.service.CheckItemService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/check_item")
public class CheckItemController {

    @Reference
    private CheckItemService checkItemService;

    /**
     * 新增
     */
    @RequestMapping("/add")
    public Result add(@RequestBody CheckItem checkItem) {
        System.out.println(checkItem);
        checkItemService.add(checkItem);
        return null;
    }
}
