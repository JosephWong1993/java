package com.wong.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.wong.dao.SetMealDao;
import com.wong.pojo.SetMeal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class SetMealServiceImpl implements SetMealService {

    @Autowired
    private SetMealDao setMealDao;

    @Override
    public void add(SetMeal setMeal, Integer[] checkGroupIds) {
        setMealDao.add(setMeal);
        if (checkGroupIds != null && checkGroupIds.length > 0) {
            //绑定套餐和检查组的多对多关系
            setSetMealAndCheckGroup(setMeal.getId(), checkGroupIds);
        }
    }

    //绑定套餐和检查组的多对多关系
    private void setSetMealAndCheckGroup(Integer id, Integer[] checkGroupIds) {
        for (Integer checkGroupId : checkGroupIds) {
            Map<String, Integer> map = new HashMap<>();
            map.put("setMealId", id);
            map.put("checkGroupId", checkGroupId);
            setMealDao.setSetMealAndCheckGroup(map);
        }
    }
}
