package com.zbl.springcloud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/4/21 14:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;

    private String message;

    private T data;

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static<T> CommonResult<T> success(T data) {
        return  new CommonResult<>(200, "成功", data);
    }

    public static<T> CommonResult<T> fail(T data) {
        return  new CommonResult<>(400, "失败", data);
    }
}
