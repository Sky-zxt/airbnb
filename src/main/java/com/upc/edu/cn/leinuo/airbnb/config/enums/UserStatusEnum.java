package com.upc.edu.cn.leinuo.airbnb.config.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
public enum UserStatusEnum implements EnumInterface {
    USER_ID_NOT_FOUND(10000, "用户ID不存在"),
    USER_IS_DELETED(10001, "用户被删除"),
    SEND_RESULT_ERROR(10002, "发送数据到回调接口失败");
    ;
    @Getter
    private Integer code;
    @Getter
    private String msg;
}
