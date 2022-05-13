package com.wong;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @SpringBootTest 代表当前类是一个SpringBoot的测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot06RestTemplateApplicationTests {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void contextLoads() {
        String forObject = restTemplate.getForObject("http://baidu.com", String.class);
        System.out.println(forObject);
    }
}