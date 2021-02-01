package com.cloud.feign.controller;


import com.cloud.feign.feginService.TestFeginService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class feignController {

    @Autowired
    TestFeginService testFeginService;

    @RequestMapping("/index")
    public String index(){
        return testFeginService.month();
    }
}
