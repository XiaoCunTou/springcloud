package com.cloud.feign.feginService.hystrixfactory;

import com.cloud.feign.feginService.TestFeginService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class TestFeginServiceHystrixFactory implements FallbackFactory<TestFeginService> {

    @Override
    public TestFeginService create(Throwable cause) {
        return new TestFeginService(){

            @Override
            public String month() {
                return "sorry..error! --HystrixFactory";
            }

            @Override
            public String month2(String name) {
                return "sorry..error! --HystrixFactory";
            }
        };
    }
}
