package com.changgou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.InetSocketAddress;

@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public KeyResolver ipKeyResolver() {
        return exchange -> {
            InetSocketAddress remoteAddress = exchange.getRequest().getRemoteAddress();
            assert remoteAddress != null;
            //Redis限流方案基于用户请求的IP地址进行限流
            return Mono.just(remoteAddress.getHostName());
        };
    }
}