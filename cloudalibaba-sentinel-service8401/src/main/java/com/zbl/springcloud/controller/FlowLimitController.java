package com.zbl.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/5/2 12:26
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testa")
    public String testA() {
        log.info("test a current thread -> " + Thread.currentThread().getName());
        return "-----test a ------";
    }

    @GetMapping("testb")
    public String testB() {
        log.info("test bb current thread -> " + Thread.currentThread().getName());
        return "-----test b ------";
    }
}
