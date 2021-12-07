package com.wong.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.wong.constant.RedisConstant;
import com.wong.dao.SetMealDao;
import com.wong.pojo.SetMeal;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SetMealServiceImpl implements SetMealService {
    private final JedisPool jedisPool;
    private final SetMealDao setMealDao;

    public SetMealServiceImpl(JedisPool jedisPool, SetMealDao setMealDao) {
        this.jedisPool = jedisPool;
        this.setMealDao = setMealDao;
    }

    @Override
    public void add(SetMeal setMeal, Integer[] checkGroupIds) {
        setMealDao.add(setMeal);
        if (checkGroupIds != null && checkGroupIds.length > 0) {
            //绑定套餐和检查组的多对多关系
            setSetMealAndCheckGroup(setMeal.getId(), checkGroupIds);
        }

        //新增套餐后需要将图片名称保存到redis
        savePic2Redis(setMeal.getImg());
    }

    @Override
    public List<SetMeal> findAll() {
        return setMealDao.findAll();
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

    //将图片名称保存到Redis
    private void savePic2Redis(String pic) {
        Jedis jedis = jedisPool.getResource();
        jedis.sadd(RedisConstant.SET_MEAL_PIC_DB_RESOURCES, pic);
        jedis.close();
    }
}
