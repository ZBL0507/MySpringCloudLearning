package com.zbl.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zbl.springcloud.dto.CommonResult;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/5/2 16:29
 */
public class MyCustomerBlockHandler {

    public static CommonResult<String> handleException(BlockException exception) {
        return CommonResult.fail("全局异常处理");
    }
}
