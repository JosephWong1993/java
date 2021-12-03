package com.wong.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@ContextConfiguration(locations = "classpath:spring_redis.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisPoolTest {
    @Autowired
    private JedisPool jedisPool;

    @Test
    public void test1() {
        for (int i = 0; i < 200; i++) {
            Jedis jedis1 = jedisPool.getResource();
        }
        Jedis jedis2 = jedisPool.getResource();
        System.out.println(jedis2);
    }
}
