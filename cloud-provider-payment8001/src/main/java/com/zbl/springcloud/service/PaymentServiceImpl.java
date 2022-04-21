package com.zbl.springcloud.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zbl.springcloud.dao.PaymentMapper;
import com.zbl.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/4/21 14:40
 */
@Service
public class PaymentServiceImpl {

    @SuppressWarnings("all")
    @Autowired
    private PaymentMapper paymentMapper;

    public void create(Payment payment) {
        paymentMapper.insert(payment);
    }

    public Payment getById(Long id) {
        return paymentMapper.selectById(id);
    }

    public Payment getSerial(String serial) {
        QueryWrapper<Payment> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Payment::getSerial, serial);
        return paymentMapper.selectOne(queryWrapper);
    }
}
