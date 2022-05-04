package com.zbl.springcloud.feign;

import com.zbl.springcloud.dto.CommonResult;
import com.zbl.springcloud.dto.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/5/4 12:43
 */
@FeignClient("seata-account-service")
public interface AccountServiceFeign {

    @PostMapping("/account/decrease")
    CommonResult<Boolean> decrease(@RequestBody OrderDTO orderDTO);
}
