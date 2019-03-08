package com.upc.edu.cn.leinuo.airbnb.config;

import com.upc.edu.cn.leinuo.airbnb.config.exception.SystemException;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class Result<T> {
    private Boolean status = true;

    private Integer code;

    private String msg;

    private String exceptionMessage;

    private String[] attachMessage = new String[0];

    private T data;

    private Result(){}

    public static<T> Result success(T data) {
        return new Result<T>().setData(data).setStatus(true);
    }
    public static<T> Result success(T data, String... attachMessage) {
        return new Result<T>().setData(data).setStatus(true).setAttachMessage(attachMessage);
    }

    public static<T> Result fail(SystemException e) {
        return new Result<T>().setStatus(false)
                .setCode(e.getCode())
                .setMsg(e.getMsg())
                .setAttachMessage(e.getAttachMessage())
                ;
    }

    public static<T> Result error(Exception e) {
        return new Result<T>().setStatus(false)
                .setExceptionMessage(e.getMessage())
                ;
    }
}
