package com.cloud.produce.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produce")
public class ProduceController {

    @Value("${server.port}")
    String port;
    @Value("${spring.application.name}")
    String name;

    @RequestMapping("/index")
    public String index(){
        return "欢迎访问："+ name + " port: " + port;
    }
}
