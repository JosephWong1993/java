package com.wong.dao;

import com.wong.pojo.SetMeal;

import java.util.List;
import java.util.Map;

public interface SetMealDao {
    void add(SetMeal setMeal);

    void setSetMealAndCheckGroup(Map<String, Integer> map);

    List<SetMeal> findAll();

    SetMeal findById(int id);
}