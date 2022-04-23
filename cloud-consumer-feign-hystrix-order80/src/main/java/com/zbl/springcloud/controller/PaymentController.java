package com.zbl.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zbl.springcloud.service.PaymentHystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/4/23 14:03
 */
@DefaultProperties(defaultFallback = "globalFallback")
@RestController
@RequestMapping("/api/order/hystrix")
public class PaymentController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @HystrixCommand
    @GetMapping("/error")
    public String paymentInfoError() {
        int i = 1 / 0;
        return "error";
    }

    @GetMapping("/ok")
    public String paymentInfoOk() {
        System.out.println("/api/order/hystrix/ok -> " + Thread.currentThread().getName());
        return paymentHystrixService.paymentInfoOk();
    }

    @HystrixCommand(fallbackMethod = "orderInfoTimeoutHandler",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
            })
    @GetMapping("/timeout")
    public String paymentInfoTimeout() {
        System.out.println("/api/order/hystrix/timeout -> " + Thread.currentThread().getName());
        return paymentHystrixService.paymentInfoTimeout();
    }

    public String orderInfoTimeoutHandler() {
        return "😭" + Thread.currentThread().getName() + " 服务器忙";
    }

    public String globalFallback() {
        return "全局 😭" + Thread.currentThread().getName() + " 服务器忙";
    }


    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启熔断器
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求次数
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //时间窗口期
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") //失败率达到多少后熔断
            })
    @GetMapping("/break/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("++++ id 不能为负数");
        }

        return Thread.currentThread().getName() + UUID.randomUUID();
    }

    public String paymentCircuitBreakerFallback(@PathVariable("id") Integer id) {
        return "id " + id + "不能为负数 " + Thread.currentThread().getName();
    }
}
