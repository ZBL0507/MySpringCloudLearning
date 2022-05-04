package com.zbl.springcloud.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/5/4 11:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_order")
public class Order {
    @TableId(type = IdType.AUTO)
    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private Integer money;

    private Integer status;
}
