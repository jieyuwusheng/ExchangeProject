package com.quanshu.exchange.support.net.core;

import com.quanshu.exchange.support.api.base.ApiCode;
import com.quanshu.exchange.support.api.base.ApiException;
import com.quanshu.exchange.support.api.base.BaseResponse;
import com.quanshu.exchange.support.utils.LogUtil;
import com.quanshu.exchange.support.utils.ToastUtil;

import rx.Subscriber;

public abstract class BaseSubscriber<T> extends Subscriber<T> {

    @Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable e) {
        onFailure(e);
    }

    @Override
    public void onNext(T t) {
        if (t instanceof BaseResponse) {
            BaseResponse baseResponse = (BaseResponse) t;
            if (baseResponse.getCode() == ApiCode.SUCCESS.getCode()) {
                onSuccess(t);
            } else {
                onFailure(new ApiException(baseResponse.getCode(), baseResponse.getMsg()));
            }
        } else {
            onFailure(new ApiException("数据解析失败"));
        }
    }

    public void onFailure(Throwable e) {
        LogUtil.printException(e);
        ToastUtil.toast(e.getMessage());
    }

    public abstract void onSuccess(T response);
}
