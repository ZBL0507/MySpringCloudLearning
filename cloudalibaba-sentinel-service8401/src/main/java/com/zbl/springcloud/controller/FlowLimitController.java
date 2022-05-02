package com.zbl.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
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

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealTestHotKey")
    public String testHotKey(String p1, String p2) {
        return "---- testHotKey ----";
    }

    public String dealTestHotKey(String p1, String p2, BlockException exception) {
        return "---- dealTestHotKey -----";
    }
}
