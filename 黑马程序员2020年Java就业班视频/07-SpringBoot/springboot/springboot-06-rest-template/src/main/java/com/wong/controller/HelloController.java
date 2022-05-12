package com.wong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/sendHttp")
    private String sendHttpRequest() {
        /*
         * 请求方式：
         * get：getForObject()
         * post：postForObject()
         * delete：delete
         * put：put
         * */
        String responseBody = restTemplate.getForObject("https://www.baidu.com/", String.class);
        System.out.println(responseBody);
        return "发送请求成功了";
    }
}
