package com.cloud.gateway;

import com.cloud.gateway.filter.AuthGlobalFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;


@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    /**
     * 开启全局过滤器
     * @return
     */
    @Bean
    public AuthGlobalFilter tokenFilter(){
        return new AuthGlobalFilter();
    }

}
