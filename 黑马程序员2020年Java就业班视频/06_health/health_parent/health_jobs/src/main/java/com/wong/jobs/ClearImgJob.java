package com.wong.jobs;

import com.wong.constant.RedisConstant;
import com.wong.utils.QiNiuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

public class ClearImgJob {

    @Autowired
    private JedisPool jedisPool;

    public void clearImg() {
        Jedis jedis = jedisPool.getResource();
        //根据Redis中保存的两个set集合进行差值计算，获得垃圾图片名称集合
        Set<String> set =
                jedis.sdiff(RedisConstant.SET_MEAL_PIC_RESOURCES,
                        RedisConstant.SET_MEAL_PIC_DB_RESOURCES);
        if (set != null && set.size() > 0) {
            for (String imgName : set) {
                //删除七牛云服务器上的图片
                QiNiuUtils.deleteFileFromQiNiu(imgName);
                System.out.println("定时任务，删除图片从七牛云：" + imgName);
                //从Redis集合中删除图片名称
                jedis.srem(RedisConstant.SET_MEAL_PIC_RESOURCES, imgName);
                System.out.println("定时任务，删除图片从redis：" + imgName);
            }
        }
        jedis.close();
    }
}
