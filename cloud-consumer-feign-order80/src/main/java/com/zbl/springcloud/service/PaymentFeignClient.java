package com.zbl.springcloud.service;

import com.zbl.springcloud.dto.CommonResult;
import com.zbl.springcloud.dto.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/4/22 20:45
 */
@FeignClient("cloud-payment-service")
@RequestMapping("/api/payment")
public interface PaymentFeignClient {

    @GetMapping("/serial")
    CommonResult<Payment> getSerial(@RequestParam("serial") String serial);
}
