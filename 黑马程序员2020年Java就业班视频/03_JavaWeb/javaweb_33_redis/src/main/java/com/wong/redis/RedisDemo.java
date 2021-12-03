package com.wong.redis;

import redis.clients.jedis.Jedis;

/**
 * Java连接数据库（redis）内存数据
 * 驱动包中的核心类 Jedis
 */
public class RedisDemo {
    public static void main(String[] args) {
//        setString();
        getString();
    }

    //Java向redis数据库存储字符串的键值对
    public static void setString() {
        //创建Jedis对象
        //构造方法中，传递数据库IP和端口
        Jedis jedis = new Jedis("10.0.108.15", 6379);
        //向数据库中存储字符串
        //redis数据库中的命令，就是Java中的方法名
        jedis.set("wong", "你好");
        jedis.close();
        System.out.println(jedis);
    }

    //取出redis数据库中的值
    public static void getString() {
        Jedis jedis = new Jedis("10.0.108.15", 6379);
        String value = jedis.get("wong2");
        System.out.println(value);
        jedis.close();
    }
}