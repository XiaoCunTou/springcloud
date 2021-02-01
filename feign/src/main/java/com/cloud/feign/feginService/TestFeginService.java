package com.cloud.feign.feginService;


import com.cloud.feign.feginService.hystrix.TestFeginServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


//@FeignClient(value="modules-produce")
@FeignClient(value="modules-produce", fallback = TestFeginServiceHystrix.class)
//@FeignClient(value="modules-produce",fallbackFactory = TestFeginServiceHystrixFactory.class,configuration = FeignConfig.class)
public interface TestFeginService {

    @RequestMapping("/produce/index")
    String month();

    @RequestMapping("/produce/index2")
    String month2(@RequestParam(value = "name") String name);
}

