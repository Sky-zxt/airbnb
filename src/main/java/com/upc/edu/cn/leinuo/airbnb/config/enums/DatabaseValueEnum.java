package com.upc.edu.cn.leinuo.airbnb.config.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum DatabaseValueEnum implements EnumInterface {
    BLOCK_DATA_DTO_VALUE_ERROR(20000, "result(审核结果字段)值不正常")
    ;
    @Getter
    private Integer code;
    @Getter
    private String msg;
}
