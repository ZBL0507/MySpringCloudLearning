package com.zbl.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/5/4 13:20
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@MapperScan("com.zbl.springcloud.dao")
public class MainStorage2002 {
    public static void main(String[] args) {
        SpringApplication.run(MainStorage2002.class, args);
    }
}
