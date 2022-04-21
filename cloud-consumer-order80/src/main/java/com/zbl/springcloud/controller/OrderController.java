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

    @GetMapping("/discovery")
    public CommonResult<Object> getServiceInfo() {
        List<String> services = discoveryClient.getServices();
        services.forEach(System.out::println);
        System.out.println("-----------------");
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(e -> {
            System.out.println("===============");
            System.out.println(e.getMetadata());
            System.out.println(e.getHost());
            System.out.println(e.getServiceId());
            System.out.println(e.getInstanceId());
            System.out.println(e.getPort());
            System.out.println(e.getUri());
        });

        return CommonResult.success(discoveryClient);
    }
}
