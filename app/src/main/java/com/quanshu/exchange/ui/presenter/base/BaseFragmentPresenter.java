package com.quanshu.exchange.ui.presenter.base;

import com.quanshu.exchange.ui.base.MyBaseFragmentActivity;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class BaseFragmentPresenter<V> {

    public MyBaseFragmentActivity mContext;

    public BaseFragmentPresenter(MyBaseFragmentActivity context) {
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