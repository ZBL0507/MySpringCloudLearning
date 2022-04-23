package com.zbl.springcloud.service;

import com.zbl.springcloud.util.RandomUtils;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/4/23 09:50
 */
@Service
public class PaymentService {

    public String paymentInfoOk() {
        return "当前线程：" + Thread.currentThread().getName() + " 😄";
    }

    public String paymentInfoTimeout() {
        long time = RandomUtils.randomInt(1, 10);
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Timeout当前线程：" + Thread.currentThread().getName() + " 😄";
    }
}
