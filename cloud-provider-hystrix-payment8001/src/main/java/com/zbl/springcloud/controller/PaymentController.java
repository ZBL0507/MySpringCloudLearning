package com.zbl.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zbl.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/4/23 09:55
 */
@RestController
@RequestMapping("/api/hystrix")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/ok")
    public String paymentInfoOk() {
        System.out.println("ok--> " + Thread.currentThread().getName());
        return paymentService.paymentInfoOk();
    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler",
            commandProperties = {
                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
            })
    @GetMapping("/timeout")
    public String paymentInfoTimeout() {
        System.out.println("timeout--> " + Thread.currentThread().getName());
        return paymentService.paymentInfoTimeout();
    }

    public String paymentInfoTimeoutHandler() {
        return Thread.currentThread().getName() + "服务器忙，请稍后再试";
    }
}
