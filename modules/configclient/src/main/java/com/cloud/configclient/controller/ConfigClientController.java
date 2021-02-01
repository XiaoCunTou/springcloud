package com.cloud.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/configClient")
public class ConfigClientController {

    @Value("${wx.dd.hsk}")
    String hsk;

    @RequestMapping("/index")
    public String index(){
        return hsk;
    }
}
