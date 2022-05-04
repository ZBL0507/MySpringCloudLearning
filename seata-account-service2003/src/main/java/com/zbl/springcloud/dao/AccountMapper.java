package com.zbl.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zbl.springcloud.po.Account;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/5/4 15:28
 */
@Repository
public interface AccountMapper extends BaseMapper<Account> {

    @Select("select * from t_account where user_id = #{userId}")
    Account selectOneByUserId(@Param("userId") Long userId);
}
