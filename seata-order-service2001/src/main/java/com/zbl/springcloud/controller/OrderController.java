package com.zbl.springcloud.controller;

import com.zbl.springcloud.dto.CommonResult;
import com.zbl.springcloud.dto.OrderDTO;
import com.zbl.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/5/4 12:59
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult<String> create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(1L);
        orderDTO.setProductId(1L);
        orderDTO.setStatus(0);
        orderService.create(orderDTO);
        return CommonResult.success("订单创建成功");
    }
}
