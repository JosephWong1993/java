package com.wong.redis;

import com.wong.utils.JedisPoolUtils;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * 测试连接池工具类
 */
public class TestJedisPool {
    public static void main(String[] args) {
//        getString();
//        setList();
        getList();
    }

    /**
     * 读取数据库中的 键
     */
    public static void getString() {
        Jedis jedis = JedisPoolUtils.getJedis();
        String value = jedis.get("wong");
        System.out.println(value);
        jedis.close();
    }

    /**
     * 数据类型 list
     * 一个键对应多个值
     */
    public static void setList() {
        Jedis jedis = JedisPoolUtils.getJedis();
        //左侧推入元素
        jedis.lpush("mylist", "a", "b", "c", "d");
        jedis.close();
    }

    /**
     * 取出类型list
     */
    public static void getList() {
        Jedis jedis = JedisPoolUtils.getJedis();
        List<String> stringList = jedis.lrange("mylist", 0, -1);
        jedis.close();

        for (String s : stringList) {
            System.out.println(s);
        }
    }
}