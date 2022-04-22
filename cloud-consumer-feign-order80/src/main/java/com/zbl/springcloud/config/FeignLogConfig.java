package com.zbl.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/4/22 21:38
 */
@Configuration
public class FeignLogConfig {

    @Bean
    public Logger.Level feignLogLevel() {
        return Logger.Level.FULL;
    }
}
