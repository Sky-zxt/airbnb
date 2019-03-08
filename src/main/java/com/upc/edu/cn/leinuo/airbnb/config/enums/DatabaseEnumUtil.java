package com.upc.edu.cn.leinuo.airbnb.config.enums;

import com.upc.edu.cn.leinuo.airbnb.config.enums.db.BlockDataResultEnum;
import com.upc.edu.cn.leinuo.airbnb.config.exception.SystemException;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
public class DatabaseEnumUtil {
    public static<T> T findEnumByStr (Class<T> e, String value) {
        for (T enumConstant : e.getEnumConstants()) {
            System.out.println(enumConstant.toString());
            if (enumConstant.toString().equals(value)){
                return enumConstant;
            }
        }
        return null;
    }
}
