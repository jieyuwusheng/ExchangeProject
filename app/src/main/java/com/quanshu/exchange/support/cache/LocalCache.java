package com.quanshu.exchange.support.cache;

import android.content.Context;

import com.quanshu.exchange.support.entity.User;
import com.quanshu.exchange.support.utils.SPUtil;

public class LocalCache implements ICache {

    private SPUtil util;

    private static final String KEY_USER = "user";

    public LocalCache(Context context) {
        this.util = new SPUtil(context);
    }

    @Override
    public boolean setCurrentUser(User currentUser) {
        return util.putObject(KEY_USER, currentUser);
    }

    @Override
    public User getCurrentUser() {
        return util.getObject(KEY_USER,User.class);
    }
}
