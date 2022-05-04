package com.zbl.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zbl.springcloud.po.Storage;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/5/4 13:29
 */
@Repository
public interface StorageMapper extends BaseMapper<Storage> {

    @Select("select * from t_storage where product_id = #{productId}")
    Storage selectOneByProductId(@Param("productId") Long productId);
}
