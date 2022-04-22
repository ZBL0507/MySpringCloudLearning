package com.zbl.springcloud.controller;

import com.zbl.springcloud.dto.CommonResult;
import com.zbl.springcloud.dto.Payment;
import com.zbl.springcloud.service.PaymentFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/4/22 20:47
 */
@RestController
@RequestMapping("/api/feign")
public class FeignTestController {

    @Resource
    private PaymentFeignClient paymentFeignClient;

    @GetMapping("/getSerial")
    public CommonResult<Payment> getSerial(String serial) {
        return paymentFeignClient.getSerial(serial);
    }
}
