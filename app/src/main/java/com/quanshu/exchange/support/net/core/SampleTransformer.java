package com.quanshu.exchange.support.net.core;

import com.trello.rxlifecycle.LifecycleProvider;
import com.trello.rxlifecycle.LifecycleTransformer;

import rx.Observable;

public class SampleTransformer<T> implements Observable.Transformer<T, T> {

    private LifecycleTransformer<T> transformer;//绑定Activity的生命周期

    public SampleTransformer(LifecycleProvider<?> rx) {
        this.transformer = rx.bindToLifecycle();
    }

    /**
     * 统一加上进度条、线程调度等
     */
    @Override
    public Observable<T> call(Observable<T> observable) {
        return observable.compose(transformer);//绑定生命周期
    }
}
