package com.zbl.springcloud.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/5/4 13:25
 */
@Data
public class StorageDTO implements Serializable {
    private Long id;
    private Long productId;
    private Long total;
    private Long used;
    private Long residue;
}
