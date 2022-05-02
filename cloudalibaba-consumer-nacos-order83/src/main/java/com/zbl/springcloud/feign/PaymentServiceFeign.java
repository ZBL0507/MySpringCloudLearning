package com.zbl.springcloud.feign;

import com.zbl.springcloud.fallback.PaymentServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/5/2 18:33
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentServiceFallback.class)
//@FeignClient(value = "nacos-payment-provider")
public interface PaymentServiceFeign {

    @GetMapping("/payment/nacos/{id}")
    String getPayment(@PathVariable("id") Integer id);
}
