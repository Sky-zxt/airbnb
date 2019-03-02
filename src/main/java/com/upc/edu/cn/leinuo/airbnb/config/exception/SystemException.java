package com.upc.edu.cn.leinuo.airbnb.config.exception;

import com.upc.edu.cn.leinuo.airbnb.config.enums.EnumInterface;
import lombok.Data;

@Data
public class SystemException extends Exception {
    private Integer code;

    private String msg;

    public SystemException(EnumInterface e) {
        this.code = e.getCode();
        this.msg = e.getMsg();
    }
}
