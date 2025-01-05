package com.n.lease.common.exception;

import com.n.lease.common.result.ResultCodeEnum;
import lombok.Data;

@Data
public class LeaseException extends RuntimeException{
    private Integer code;

    public LeaseException(String message, Integer code) {
        super(message);
        this.code = code;
    }
    public LeaseException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }
}
