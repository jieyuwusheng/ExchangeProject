package com.quanshu.exchange.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.quanshu.exchange.ui.presenter.base.BaseFragmentPresenter;
import com.trello.rxlifecycle.components.support.RxFragmentActivity;

import butterknife.ButterKnife;

/**
 * Created by jye on 2017/11/10.
 */

public abstract class MyBaseFragmentActivity<V, T extends BaseFragmentPresenter<V>> extends RxFragmentActivity {

    public T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        //判断是否使用MVP模式
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView((V) this);//因为之后所有的子类都要实现对应的View接口
        }
    }

    public abstract T createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
