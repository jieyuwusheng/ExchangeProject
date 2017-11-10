package com.quanshu.exchange.ui.presenter.base;

import com.quanshu.exchange.ui.base.MyBaseActivity;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class BasePresenter<V> {

    public MyBaseActivity mContext;

    public BasePresenter(MyBaseActivity context) {
        mContext = context;
    }

    protected Reference<V> mViewRef;

    public void attachView(V view) {
        mViewRef = new WeakReference<V>(view);
    }

    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    public V getView() {
        return mViewRef != null ? mViewRef.get() : null;
    }

}