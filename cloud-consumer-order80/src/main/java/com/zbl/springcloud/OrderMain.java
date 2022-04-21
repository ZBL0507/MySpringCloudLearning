package com.zbl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/4/21 18:57
 */
@EnableEurekaClient
@SpringBootApplication
public class OrderMain {
    public static void main(String[] args) {

        SpringApplication.run(OrderMain.class, args);

    }
}
