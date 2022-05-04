package com.zbl.springcloud.service.Impl;

import com.zbl.springcloud.dao.AccountMapper;
import com.zbl.springcloud.dto.AccountDTO;
import com.zbl.springcloud.po.Account;
import com.zbl.springcloud.service.AccountService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/5/4 15:30
 */
@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public void decrease(AccountDTO accountDTO) {
        Account account = accountMapper.selectOneByUserId(accountDTO.getUserId());

        log.info("account服务xid" + RootContext.getXID());

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        account.setTotal(account.getTotal() - 100);
        account.setUsed(account.getUsed() + 100);
        account.setResidue(account.getResidue() - 100);

        accountMapper.updateById(account);
    }
}
