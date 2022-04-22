package com.zbl.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/4/22 17:57
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule rule() {
        return new RandomRule();
    }
}
