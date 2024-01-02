package com.zbx.hytool.util;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {

    private final int code;
    private final String msg;
    private final Object data;

    private static final int CODE_SUCCESS = 1;
    private static final int CODE_ERROR = 0;

    private Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 请求成功
     */
    public static Result ok() {
        return new Result(CODE_SUCCESS, null, null);
    }

    /**
     * 返回数据
     */
    public static Result data(Object data) {
        return new Result(CODE_SUCCESS, null, data);
    }

    /**
     * 请求失败
     *
     * @param msg 失败消息
     */
    public static Result fail(String msg) {
        return new Result(CODE_ERROR, msg, null);
    }

}
