package com.zbl.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zbl.springcloud.dto.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/5/2 16:06
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult<String> byResource() {
        return CommonResult.success("按资源名称限流测试");
    }

    public CommonResult<String> handleException(BlockException exception) {
        return CommonResult.fail("服务不可用");
    }

    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult<String> byUrl() {
        return CommonResult.success("byUrl,成功");
    }
}
