package com.quanshu.exchange.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.quanshu.exchange.ui.presenter.base.BasePresenter;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by jye on 2017/11/8.
 */
public abstract class MyBaseActivity<V, T extends BasePresenter<V>> extends RxAppCompatActivity {

    public T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
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
