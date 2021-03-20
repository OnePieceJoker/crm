package com.joker.crm.common.api;

import java.util.HashMap;
import java.util.Map;

import com.joker.crm.common.constant.ResultCodeEnum;

import lombok.Data;

/**
 *
 * @author Mr.Joker
 * @date 2021/03/18
 * @time 12:31:00
 * @description 通用的返回结果封装类
 */
public @Data class R {
    
    private Boolean success;

    private Integer code;

    private String message;

    private Map<String, Object> data = new HashMap<>();

    private R() {}

    /**
     * 通用的返回成功消息体
     * @return
     */
    public static R ok() {
        R r = new R();
        r.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return r;
    }

    /**
     * 通过的返回失败的消息体，未知错误
     * @return
     */
    public static R error() {
        R r = new R();
        r.setSuccess(ResultCodeEnum.UNKNOWN_ERROR.getSuccess());
        r.setCode(ResultCodeEnum.UNKNOWN_ERROR.getCode());
        r.setMessage(ResultCodeEnum.UNKNOWN_ERROR.getMessage());
        return r;
    }

    /**
     * 设置自定义结果枚举
     * @param result
     * @return
     */
    public static R setResult(ResultCodeEnum result) {
        R r = new R();
        r.setSuccess(result.getSuccess());
        r.setCode(result.getCode());
        r.setMessage(result.getMessage());
        return r;
    }

    // -------------- 链式调用 -----------------

    /**
     * 自定义返回数据
     * @param map
     * @return
     */
    public R data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }

    /**
     * 通用设置data
     * @param key
     * @param value
     * @return
     */
    public R data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    /**
     * 自定义状态信息
     * @param message
     * @return
     */
    public R message(String message) {
        this.setMessage(message);
        return this;
    }

    /**
     * 自定义状态码
     * @param code
     * @return
     */
    public R code(Integer code) {
        this.setCode(code);
        return this;
    }

    /**
     * 自定义返回结果
     * @param success
     * @return
     */
    public R success(Boolean success) {
        this.setSuccess(success);
        return this;
    }
}
