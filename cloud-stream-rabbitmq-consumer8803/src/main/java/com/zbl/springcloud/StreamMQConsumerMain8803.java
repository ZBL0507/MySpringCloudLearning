package com.zbl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/4/24 17:14
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMQConsumerMain8803 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMQConsumerMain8803.class, args);
    }
}
