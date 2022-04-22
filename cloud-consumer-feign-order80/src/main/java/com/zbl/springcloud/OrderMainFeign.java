package com.zbl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/4/21 18:57
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class OrderMainFeign {
    public static void main(String[] args) {

        SpringApplication.run(OrderMainFeign.class, args);

    }
}
