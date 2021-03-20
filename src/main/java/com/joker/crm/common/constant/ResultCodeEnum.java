package com.joker.crm.common.constant;

import lombok.Getter;

/**
 *
 * @author Mr.Joker
 * @date 2021/03/18
 * @time 13:45:51
 * @description 通用的返回消息枚举类
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(true, 200, "success"),
    UNKNOWN_ERROR(false, 201, "unknown error"),
    PARAM_ERROR(false, 202, "param error"),
    NULL_POINTER(false, 203, "null pointer"),
    HTTP_CLIENT_ERROR(false, 204, "http client error"),
    NOT_FOUND(false, 404, "not found");

    private Boolean success;
    private Integer code;
    private String message;

    ResultCodeEnum(boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
    
}
