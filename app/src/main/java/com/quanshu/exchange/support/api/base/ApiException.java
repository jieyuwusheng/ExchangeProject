package com.quanshu.exchange.support.api.base;

public class ApiException extends RuntimeException {
    private int code;

    public static final int DEFALT_ERROR_CODE = -1;//默认异常，数据解析失败

    public ApiException(String message) {
        this(DEFALT_ERROR_CODE, message);
    }

    public ApiException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
