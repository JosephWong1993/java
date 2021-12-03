package com.wong.service;

import com.wong.pojo.SetMeal;

/**
 * 体检套餐服务接口
 */
public interface SetMealService {
    void add(SetMeal setMeal, Integer[] checkGroupIds);
}
