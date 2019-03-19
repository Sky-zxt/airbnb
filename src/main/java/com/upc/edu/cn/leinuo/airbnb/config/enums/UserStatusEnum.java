package com.upc.edu.cn.leinuo.airbnb.config.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum UserStatusEnum implements EnumInterface {
    ID_NOT_FOUND(10000, "用户ID不存在"),
    SEND_RESULT_ERROR(10002, "发送数据到回调接口失败"),
    USER_IS_DELETED(10001, "用户被删除"),
    REPEAT_AUDIT(10003, "不可重复审核"),
    TOO_MAX_AUDIT_LEVEL(10004, "超过了最大的审核级别"),
    LOSS_AUDIT(10005, "丢失一次审核(未经过第n次审核就开始n+1次审核)"),
    AUDIT_IS_FAILED(10006, "上一次审核已经失败")

    ;
    @Getter
    private Integer code;
    @Getter
    private String msg;
}
