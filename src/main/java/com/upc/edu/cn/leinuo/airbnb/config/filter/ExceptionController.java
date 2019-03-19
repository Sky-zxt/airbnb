package com.upc.edu.cn.leinuo.airbnb.config.filter;

import com.upc.edu.cn.leinuo.airbnb.config.Result;
import com.upc.edu.cn.leinuo.airbnb.config.exception.SystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = Exception.class)
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.error(e);
    }

}
