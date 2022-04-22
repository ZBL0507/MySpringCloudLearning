package com.zbl.springcloud.controller;

import com.zbl.springcloud.dto.CommonResult;
import com.zbl.springcloud.dto.Payment;
import com.zbl.springcloud.service.PaymentServiceImpl;
import com.zbl.springcloud.util.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/4/21 14:46
 */
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @SuppressWarnings("all")
    @Autowired
    private PaymentServiceImpl paymentService;

    @PostMapping("/create")
    public CommonResult<Boolean> create(@RequestBody Payment payment) {
        paymentService.create(payment);

        return CommonResult.success(true);
    }

    @GetMapping("/serial")
    public CommonResult<Payment> getSerial(String serial) {
        try {
            TimeUnit.SECONDS.sleep(RandomUtils.randomInt(1, 5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Payment payment = paymentService.getSerial(serial);
        payment.setSerial(payment.getSerial() + " port: " + port);
        return CommonResult.success(payment);
    }
}
