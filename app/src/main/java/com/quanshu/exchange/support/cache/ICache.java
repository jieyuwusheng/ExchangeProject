package com.quanshu.exchange.support.cache;


import com.quanshu.exchange.support.entity.User;

public interface ICache {

    /**
     * 设置用户信息
     */
    boolean setCurrentUser(User currentUser);

    User getCurrentUser();
}
