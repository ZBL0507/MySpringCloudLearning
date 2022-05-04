package com.zbl.springcloud.service;

import com.zbl.springcloud.domain.Order;
import com.zbl.springcloud.dto.OrderDTO;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/5/4 12:31
 */
public interface OrderService {

    void create(OrderDTO order);
}
