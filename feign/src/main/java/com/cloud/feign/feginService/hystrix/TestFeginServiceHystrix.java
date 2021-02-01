package com.cloud.feign.feginService.hystrix;

import com.cloud.feign.feginService.TestFeginService;
import org.springframework.stereotype.Component;

@Component
public class TestFeginServiceHystrix implements TestFeginService {

    @Override
    public String month() {
        return "sorry..error! --Hystrix";
    }

    @Override
    public String month2(String name) {
        return "sorry..error! --Hystrix";
    }
}
