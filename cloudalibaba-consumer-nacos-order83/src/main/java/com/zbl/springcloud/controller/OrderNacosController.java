package com.zbl.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zbl.springcloud.util.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/4/30 12:37
 */
@RestController
@Slf4j
public class OrderNacosController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Long id) {
        return restTemplate.getForObject(serviceUrl + "/payment/nacos/" + id, String.class);
    }

    @GetMapping("/consumer/fallback")
    @SentinelResource(value = "fallback",
            fallback = "handleFallback",
            blockHandler = "handleBlockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class})
    public String paymentInfo() {
        int rand = RandomUtils.randomInt(0, 10);
        if (rand > 6) {
            throw new IllegalArgumentException();
        }
        return restTemplate.getForObject(serviceUrl + "/payment/nacos/" + 2322, String.class);
    }

    public String handleFallback(Throwable e) {
        return "------出现业务异常-----";
    }

    public String handleBlockHandler(BlockException e) {
        return "---handleBlockHandler----";
    }
}
