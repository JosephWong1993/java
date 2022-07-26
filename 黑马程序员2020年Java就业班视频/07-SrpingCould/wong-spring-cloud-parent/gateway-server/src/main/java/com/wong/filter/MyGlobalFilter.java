package com.wong.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 全局的鉴权过滤器
 * 必须注入Spring的容器中，才能生效
 */
@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {
    /**
     * 所有的请求地址都会经过当前的方法
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 首先，从请求中获取参数token
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        // 判断token是否存在
        MultiValueMap<String, String> queryParams = request.getQueryParams();
        String token = queryParams.getFirst("token");
        // 如果存在，放行
        if (token == null) {
            // 如果不存在，拦截，并提示用户未授权
            // 设置错误状态码：401，404（资源为找到）,500(服务器错误)
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        return chain.filter(exchange);
    }

    /**
     * 返回值代表当前自定义过滤器的执行顺序，返回值越小执行顺序越靠前
     */
    @Override
    public int getOrder() {
        return 0;
    }
}