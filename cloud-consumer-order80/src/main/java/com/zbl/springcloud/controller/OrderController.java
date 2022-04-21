package com.zbl.springcloud.controller;

import com.zbl.springcloud.entities.CommonResult;
import com.zbl.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/4/21 19:15
 */
@RestController
@RequestMapping("/api/consumer")
public class OrderController {

    private final static String PaymentUrl = "http://localhost:8001";

    @SuppressWarnings("all")
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/order/create")
    @SuppressWarnings("unchecked")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PaymentUrl + "/api/payment/create", payment, CommonResult.class);
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/order/serial/{serial}")
    public CommonResult<Payment> getPayment(@PathVariable("serial") String serial) {
        return restTemplate.getForObject(PaymentUrl + "/api/payment/serial?serial=" + serial, CommonResult.class);
    }
}
