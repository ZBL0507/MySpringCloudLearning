package com.zbl.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/5/4 11:26
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.zbl.springcloud.dao")
@EnableFeignClients
public class MainOrder2001 {
    public static void main(String[] args) {
        SpringApplication.run(MainOrder2001.class, args);
    }
}
