package com.quanshu.exchange.support.cache;

import com.quanshu.exchange.support.entity.User;


public class MemoryCache implements ICache {

    private User currentUser;

    @Override
    public boolean setCurrentUser(User userEntity) {
        this.currentUser = userEntity;
        return true;
    }

    @Override
    public User getCurrentUser() {
        return currentUser;
    }

}
