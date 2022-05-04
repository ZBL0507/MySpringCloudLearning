package com.zbl.springcloud.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/5/4 13:25
 */
@Data
@TableName("t_storage")
public class Storage {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long productId;
    private Long total;
    private Long used;
    private Long residue;
}
