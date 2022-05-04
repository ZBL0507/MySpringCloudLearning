package com.zbl.springcloud.feign;

import com.zbl.springcloud.domain.Order;
import com.zbl.springcloud.dto.CommonResult;
import com.zbl.springcloud.dto.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/5/4 12:44
 */
@FeignClient(value = "seata-storage-service")
public interface StorageServiceFeign {

    @PostMapping("/store/decrease")
    CommonResult<Boolean> decrease(@RequestBody OrderDTO orderDTO);
}
