package com.upc.edu.cn.leinuo.airbnb.config.exception;

import com.upc.edu.cn.leinuo.airbnb.config.enums.EnumInterface;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SystemException extends Exception {
    private Integer code;

    private String msg;

    private String[] attachMessage = new String[0];

    public SystemException(EnumInterface e) {
        this.code = e.getCode();
        this.msg = e.getMsg();
    }

    public SystemException(EnumInterface e, String... attachMessage) {
        this.code = e.getCode();
        this.msg = e.getMsg();
        this.attachMessage = attachMessage;
    }
}
