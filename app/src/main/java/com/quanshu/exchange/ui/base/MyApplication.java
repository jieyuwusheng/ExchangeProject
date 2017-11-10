package com.quanshu.exchange.ui.base;

import android.app.Application;

import com.quanshu.exchange.support.cache.DoubleCache;
import com.quanshu.exchange.support.cache.ICache;
import com.quanshu.exchange.support.entity.User;

/**
 * Created by jye on 2017/11/8.
 */

public class MyApplication extends Application {

    public static MyApplication instance;

    public static MyApplication getInstance() {
        return instance;
    }

    public ICache getCache() {
        return cache;
    }

    private ICache cache;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initCache();
    }

    private void initCache() {
        cache = new DoubleCache(this);
    }

    public User getCurrentUser() {
        return cache.getCurrentUser();
    }

    public void setCurrentUser(User user) {
        cache.setCurrentUser(user);
    }
}
