package com.zbl.springcloud.controller;

import com.zbl.springcloud.dto.CommonResult;
import com.zbl.springcloud.dto.OrderDTO;
import com.zbl.springcloud.dto.StorageDTO;
import com.zbl.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/5/4 13:34
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @PostMapping("/store/decrease")
    public CommonResult<Boolean> decrease(@RequestBody OrderDTO orderDTO) {
        StorageDTO storageDTO = new StorageDTO();
        storageDTO.setProductId(orderDTO.getProductId());
        storageService.decrease(storageDTO);
        return CommonResult.success(true);
    }
}
