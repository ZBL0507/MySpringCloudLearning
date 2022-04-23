package com.zbl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/4/23 13:59
 */
@EnableHystrix
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class OrderMainHystrix {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainHystrix.class, args);
    }
}
