package com.zbl.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zbl.springcloud.entities.Payment;
import org.springframework.stereotype.Repository;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/4/21 14:24
 */
@Repository
public interface PaymentMapper extends BaseMapper<Payment> {
}
