package com.quanshu.exchange.support.net.core;

import com.quanshu.exchange.support.exception.UnknownException;
import com.quanshu.exchange.support.net.loading.ILoading;
import com.quanshu.exchange.support.utils.LogUtil;
import com.quanshu.exchange.ui.widget.dialog.LoadingDialog;
import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Func1;

public class BaseTransformer<T> implements Observable.Transformer<T, T> {

    private LifecycleTransformer<T> transformer;//绑定Activity的生命周期
    private ILoading loading;//网络进度条

    public BaseTransformer(RxAppCompatActivity rx) {
        this(rx, true);
    }

    public BaseTransformer(RxAppCompatActivity rx, boolean hasProgressDialog) {
        this(rx, hasProgressDialog ? new LoadingDialog(rx) : null);
    }

    public BaseTransformer(RxAppCompatActivity rx, ILoading loading) {
        this.transformer = rx.bindToLifecycle();
        this.loading = loading;
    }

    /**
     * 统一加上进度条、线程调度等
     */
    @Override
    public Observable<T> call(Observable<T> observable) {
        return observable
                .throttleFirst(1, TimeUnit.SECONDS)//取1秒之内的最后一次,防止重复提交
                .subscribeOn(BaseScheduler.getScheduler())//在异步线程执行耗时操作，对上面的操作有用
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        if (loading != null && !loading.isShowing()) {
                            loading.show();
                        }
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())//在主线程显示进度条，对上面的操作有用
                .compose(transformer)//绑定生命周期
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends T>>() {
                    @Override
                    public Observable<? extends T> call(Throwable throwable) {
                        LogUtil.printException(throwable);
                        if (loading != null) {
                            loading.cancel();
                        }
                        return Observable.error(new UnknownException(throwable));
                    }
                })//公共错误拦截
                .map(new Func1<T, T>() {
                    @Override
                    public T call(T t) {
                        if (loading != null) {
                            loading.cancel();
                        }
                        return t;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread());//在主线程回调，对下面的操作有用
    }
}
