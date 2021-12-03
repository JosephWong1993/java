package com.wong.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wong.constant.MessageConstant;
import com.wong.constant.RedisConstant;
import com.wong.entity.Result;
import com.wong.pojo.SetMeal;
import com.wong.service.SetMealService;
import com.wong.utils.QiNiuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.UUID;

/**
 * 体检套餐管理
 */
@RestController
@RequestMapping("/set_meal")
public class SetMealController {

    private final JedisPool jedisPool;

    public SetMealController(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    @Reference
    private SetMealService setMealService;

    /**
     * 文件上传
     *
     * @param imgFile
     * @return
     */
    @RequestMapping("/upload")
    public Result upload(MultipartFile imgFile) {
        Jedis jedis = null;
        try {
            String originalFilename = imgFile.getOriginalFilename();//原始文件名
            int lastIndexOf = originalFilename.lastIndexOf(".");
            String suffix = originalFilename.substring(lastIndexOf);
            String fileName = UUID.randomUUID().toString() + suffix;
            QiNiuUtils.upload2QiNiu(imgFile.getBytes(), fileName);
            //完成文件上传后需要将图片名称保存到redis集合中
            jedis = jedisPool.getResource();
            jedis.sadd(RedisConstant.SET_MEAL_PIC_RESOURCES, fileName);
            return new Result(true, MessageConstant.PIC_UPLOAD_SUCCESS, fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.PIC_UPLOAD_FAIL);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    //新增
    @RequestMapping("/add")
    public Result add(@RequestBody SetMeal setMeal,
                      Integer[] checkGroupIds) {
        try {
            setMealService.add(setMeal, checkGroupIds);
        } catch (Exception e) {
            //新增套餐失败
            return new Result(false, MessageConstant.ADD_SETMEAL_FAIL);
        }
        //新增套餐成功
        return new Result(true, MessageConstant.ADD_SETMEAL_SUCCESS);
    }
}
