package com.zbl.springcloud.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import com.zbl.springcloud.dao.StorageMapper;
import com.zbl.springcloud.dto.StorageDTO;
import com.zbl.springcloud.po.Storage;
import com.zbl.springcloud.service.StorageService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/5/4 13:31
 */
@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageMapper storageMapper;

    @Override
    public void decrease(StorageDTO storageDTO) {
        log.info("storage服务xid" + RootContext.getXID());

        Storage storage = storageMapper.selectOneByProductId(storageDTO.getProductId());
        storage.setTotal(storage.getTotal() - 1);
        storage.setUsed(storage.getUsed() + 1);
        storage.setResidue(storage.getResidue() - 1);

        storageMapper.updateById(storage);
    }
}
