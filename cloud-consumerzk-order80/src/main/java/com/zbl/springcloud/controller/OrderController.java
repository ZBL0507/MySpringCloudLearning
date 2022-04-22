package com.zbl.springcloud.controller;

import com.zbl.springcloud.dto.CommonResult;
import com.zbl.springcloud.dto.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/4/21 19:15
 */
@RestController
@RequestMapping("/api/consumer")
public class OrderController {

//    private final static String PaymentUrl = "http://localhost:8001";
    private final static String PaymentUrl = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private DiscoveryClient discoveryClient;

}
