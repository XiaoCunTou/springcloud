package com.cloud.client2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/client2")
public class Client2Controller {

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger LOG = Logger.getLogger(Client2Controller.class.getName());

    @RequestMapping("/hi")
    public String callHome(){
        LOG.log(Level.INFO, "hi is being called");
        return "i'm zipkin-client2";
    }

    @RequestMapping("/info")
    public String info(){
        LOG.log(Level.INFO, "info is being called");
        return restTemplate.getForObject("http://localhost:8720/info",String.class);
    }

}
