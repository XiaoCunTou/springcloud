package com.cloud.ribbon.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/ribbon")
public class RibbonController {


    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/index")
    public String index(){
//        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://modules-produce/produce/index",String.class);
    }
}
