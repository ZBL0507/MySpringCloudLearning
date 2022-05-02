package com.zbl.springcloud.fallback;

import com.zbl.springcloud.feign.PaymentServiceFeign;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/5/2 18:40
 */
@Component
public class PaymentServiceFallback implements PaymentServiceFeign {

    @Override
    public String getPayment(@PathVariable(value = "id") Integer id) {
        return "服务降级处理：" + id;
    }
}
