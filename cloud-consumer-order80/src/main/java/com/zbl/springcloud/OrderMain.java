package com.zbl.springcloud;

import com.zbl.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/4/21 18:57
 */
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class OrderMain {
    public static void main(String[] args) {

        SpringApplication.run(OrderMain.class, args);

    }
}
