package com.zbl.springcloud.service;

import com.zbl.springcloud.dto.AccountDTO;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/5/4 15:29
 */
public interface AccountService {

    void decrease(AccountDTO accountDTO);
}
