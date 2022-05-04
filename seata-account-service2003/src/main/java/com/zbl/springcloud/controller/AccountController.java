package com.zbl.springcloud.controller;

import com.zbl.springcloud.dto.AccountDTO;
import com.zbl.springcloud.dto.CommonResult;
import com.zbl.springcloud.dto.OrderDTO;
import com.zbl.springcloud.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/5/4 15:43
 */
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;


    @PostMapping("/account/decrease")
    public CommonResult<Boolean> decrease(@RequestBody OrderDTO orderDTO) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUserId(orderDTO.getUserId());
        accountService.decrease(accountDTO);
        return CommonResult.success(true);
    }
}
