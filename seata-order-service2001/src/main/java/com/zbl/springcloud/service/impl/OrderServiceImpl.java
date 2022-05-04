package com.zbl.springcloud.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.zbl.springcloud.dao.OrderMapper;
import com.zbl.springcloud.domain.Order;
import com.zbl.springcloud.dto.OrderDTO;
import com.zbl.springcloud.feign.AccountServiceFeign;
import com.zbl.springcloud.feign.StorageServiceFeign;
import com.zbl.springcloud.service.OrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/5/4 12:32
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private StorageServiceFeign storageServiceFeign;

    @Resource
    private AccountServiceFeign accountServiceFeign;

    @Override
    @GlobalTransactional(name = "fsp_creat_group", rollbackFor = Exception.class)
    public void create(OrderDTO order) {
        log.info("订单服务xid" + RootContext.getXID());
        log.info("--------开始新建订单------");
        Order po = new Order();
        BeanUtil.copyProperties(order, po);
        orderMapper.insert(po);
        order.setId(po.getId());
        log.info("-------订单新建结束------");

        log.info("-------开始扣减库存------");
        storageServiceFeign.decrease(order);
        log.info("------扣减库存end------");

        log.info("扣减余额。。。。");
        accountServiceFeign.decrease(order);
        log.info("扣减余额end......");

        po.setStatus(1);
        orderMapper.updateById(po);
    }
}
