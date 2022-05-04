package com.zbl.springcloud.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/5/4 15:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_account")
public class Account {

    @TableId(type = IdType.AUTO)
    private Long id;
    private Long userId;
    private Long total;
    private Long used;
    private Long residue;
}
