package com.wong.service;

import com.wong.config.FeignConfiguration;
import com.wong.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @FeignClient 声明当前接口是feign客户端的接口
 * value属性：设置服务的名称
 * fallback属性：指定服务降级的处理类
 * configuration属性：指定当前feign客户端的配置类
 */
@FeignClient(value = "provider-service",
        fallback = UserServiceFallback.class,
        configuration = FeignConfiguration.class)
public interface UserService {

    @RequestMapping("/user/query_by_id")
    User queryById(@RequestParam("id") Integer id);
}