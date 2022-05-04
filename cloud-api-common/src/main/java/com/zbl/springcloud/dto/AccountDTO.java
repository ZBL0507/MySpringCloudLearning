package com.zbl.springcloud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/5/4 15:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO implements Serializable {

    private Long id;
    private Long userId;
    private Long total;
    private Long used;
    private Long residue;
}
