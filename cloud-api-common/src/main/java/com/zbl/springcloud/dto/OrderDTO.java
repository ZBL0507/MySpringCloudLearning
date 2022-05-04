package com.zbl.springcloud.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/5/4 12:48
 */
@Data
public class OrderDTO implements Serializable {
    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private Integer money;

    private Integer status;
}
