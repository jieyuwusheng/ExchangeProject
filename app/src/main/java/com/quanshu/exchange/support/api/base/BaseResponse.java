package com.quanshu.exchange.support.api.base;

import lombok.Data;

@Data
public class BaseResponse<T> {

    private int code;//状态码
    private String msg;//具体状态码描述
    private T info;//具体数据

}
