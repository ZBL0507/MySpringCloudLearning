package com.zbl.springcloud.controller;

import com.zbl.springcloud.entities.CommonResult;
import com.zbl.springcloud.entities.Payment;
import com.zbl.springcloud.service.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/4/21 14:46
 */
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

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
        Payment payment = paymentService.getSerial(serial);
        return CommonResult.success(payment);
    }
}
