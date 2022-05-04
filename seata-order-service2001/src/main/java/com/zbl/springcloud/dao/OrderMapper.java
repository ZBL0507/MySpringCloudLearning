package com.zbl.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zbl.springcloud.domain.Order;
import org.springframework.stereotype.Repository;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/5/4 11:47
 */
@Repository
public interface OrderMapper extends BaseMapper<Order> {
}
