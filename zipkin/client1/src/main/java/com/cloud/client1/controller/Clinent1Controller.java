package com.cloud.client1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/client1")
public class Clinent1Controller {

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger LOG = Logger.getLogger(Clinent1Controller.class.getName());

    @RequestMapping("/hi")
    public String callHome(){
        LOG.log(Level.INFO, "calling trace zipkin-client1  ");
        return restTemplate.getForObject("http://localhost:8725/client2/hi", String.class);
    }

    @RequestMapping("/info")
    public String info(){
        LOG.log(Level.INFO, "calling trace zipkin-client1 ");
        return "i'm zipkin-client1";
    }


}
