package com.zbl.springcloud.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/4/21 14:19
 */
@Data
public class Payment implements Serializable {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 支付流水号
     */
    private String serial;
}
