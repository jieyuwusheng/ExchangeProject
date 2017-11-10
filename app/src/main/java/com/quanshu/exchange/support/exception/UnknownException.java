package com.quanshu.exchange.support.exception;

public class UnknownException extends RuntimeException {

    public UnknownException(String message) {
        super(message);
    }

    public UnknownException(Throwable cause) {
        super("未知异常", cause);
    }
}
