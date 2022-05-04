package com.zbl.springcloud.service;

import com.zbl.springcloud.dto.StorageDTO;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/5/4 13:31
 */
public interface StorageService {

    void decrease(StorageDTO storageDTO);
}
