package com.cloud.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义过滤器  实现GatewayFilter和Ordered
 *  在路由中配置使用过滤器  这个过滤器只是局部的，如果我们有多个路由就需要一个一个来配置
 */
@Component
public class AuthFilter implements GatewayFilter, Ordered {

    private static final Logger log = LoggerFactory.getLogger(AuthFilter.class);
    private static final String ELAPSED_TIME_BEGIN = "elapsedTimeBegin";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String url = exchange.getRequest().getURI().getPath();
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        // 跳过不需要验证的路径
        // 验证token
        // 设置过期时间
        // 设置用户信息到请求

        return chain.filter(exchange);


        /**
         * 可以记录方法耗时
         *  chain.filter(exchange) 之前为路由之前pre状态
         *  之后为post状态 路由之后  之后的也就是then里边的是post部分
         */
//        exchange.getAttributes().put(ELAPSED_TIME_BEGIN, System.currentTimeMillis());
//        return chain.filter(exchange).then(
//                Mono.fromRunnable(() -> {
//                    Long startTime = exchange.getAttribute(ELAPSED_TIME_BEGIN);
//                    if (startTime != null) {
//                        log.info(exchange.getRequest().getURI().getRawPath() + ": " + (System.currentTimeMillis() - startTime) + "ms");
//                    }
//                })
//        );
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

}
