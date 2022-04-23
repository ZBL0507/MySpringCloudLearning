package com.zbl.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/4/21 14:09
 */
@EnableEurekaClient
@EnableCircuitBreaker
@MapperScan("com.zbl.springcloud.dao")
@SpringBootApplication
public class PaymentMainHystrix8001 {
    public static void main(String[] args) {

        SpringApplication.run(PaymentMainHystrix8001.class, args);

    }
}
