package com.cloud.ribbon.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class RibbonConfig {

    /**
     * LoadBalanced声明restRemplate开启负载均衡的功能  Ribbon默认的策略是轮询
     * 可以使用服务名称来调用接口 不开启是不能使用服务名称调用接口的 意味着要使用ip+port的方式--> 无法负载
     */

    /**
     * RestTemplate 是什么
     * 传统情况下在java代码里访问restful服务，一般使用Apache的HttpClient。
     * 不过此种方法使用起来太过繁琐。spring提供了一种简单便捷的模板类来进行操作，这就是RestTemplate。
     */

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }


    /**
     * 显示实例化 负载均衡的策略对象，那么默认的轮询策略就会失效
     * RoundRobinRule   轮询策略（默认）
     * WeightedResponseTimeRule     权重轮询策略
     * RandomRule       随机策略
     * BestAvailableRule    最少并发数策略
     * RetryRule    在“选定的负载均衡策略”基础上进行重试机制
     * AvailabilityFilteringRule    可用性敏感策略
     * ZoneAvoidanceRule    区域敏感性策略
     */
    /*@Bean
    public RandomRule createRule(){
        return new RandomRule();
    }*/
}
