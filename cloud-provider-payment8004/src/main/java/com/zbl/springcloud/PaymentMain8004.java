package com.zbl.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/4/21 14:09
 */
@EnableDiscoveryClient
@MapperScan("com.zbl.springcloud.dao")
@SpringBootApplication
public class PaymentMain8004 {
    public static void main(String[] args) {

        SpringApplication.run(PaymentMain8004.class, args);

    }
}
