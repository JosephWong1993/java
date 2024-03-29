package com.wong.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wong.constant.MessageConstant;
import com.wong.entity.Result;
import com.wong.pojo.SetMeal;
import com.wong.service.SetMealService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/set_meal")
public class SetMealController {
    @Reference
    private SetMealService setMealService;

    //获取所有套餐信息
    @RequestMapping("/get_set_meal")
    public Result getSetMeal() {
        try {
            List<SetMeal> list = setMealService.findAll();
            return new Result(true, MessageConstant.GET_SETMEAL_LIST_SUCCESS, list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true, MessageConstant.GET_SETMEAL_LIST_FAIL);
        }
    }

    //根据id查询套餐信息
    @RequestMapping("/find_by_id")
    public Result findById(int id) {
        try {
            SetMeal setmeal = setMealService.findById(id);
            return new Result(true, MessageConstant.QUERY_SETMEAL_SUCCESS, setmeal);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_SETMEAL_FAIL);
        }
    }
}