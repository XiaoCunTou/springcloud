package com.cloud.gateway.config;

import com.cloud.gateway.filter.AuthFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    /**
     * 支持通过 Java 的流式 API 进行路由的定义，
     * 如下就是一个和通过配置文件配置的等效的路由，并且可以和配置文件搭配使用
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        // @formatter:off
        return builder.routes()
                .route(r -> r.path("/feign/**")
                        .filters(f -> f.stripPrefix(1)
                                //增加自定义过滤器
//                                .filter(new AuthFilter())
                                .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
                        .uri("lb://FEIGN")
                        .order(0)
                        .id("feign")
                )
                .route(r -> r.path("/course/**")
                                .filters(f -> f.stripPrefix(1)
                                        //增加自定义过滤器
//                                .filter(new AuthFilter())
                                        .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
                                .uri("lb://MODULES-SYSTEM")
                                .order(0)
                                .id("course")
                )
                .build();
        // @formatter:on
    }
}
