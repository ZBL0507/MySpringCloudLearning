package com.zbl.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/4/23 14:01
 */
@FeignClient("CLOUD-PAYMENT-HYSTRIX-SERVICE")
@RequestMapping("/api/hystrix")
public interface PaymentHystrixService {

    @GetMapping("/ok")
    String paymentInfoOk();

    @GetMapping("/timeout")
    String paymentInfoTimeout();
}
