package com.zbl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/4/30 12:33
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class OrderMain83 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain83.class, args);
    }
}
