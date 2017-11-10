package com.quanshu.exchange.support.cache;

import android.content.Context;

import com.quanshu.exchange.support.entity.User;

/**
 * 双重缓存
 */
public class DoubleCache implements ICache {

    private ICache memoryCache;
    private ICache localCache;

    public DoubleCache(Context context) {
        this.memoryCache = new MemoryCache();
        this.localCache = new LocalCache(context);
    }

    @Override
    public boolean setCurrentUser(User user) {
        return memoryCache.setCurrentUser(user) && localCache.setCurrentUser(user);
    }

    @Override
    public User getCurrentUser() {
        return getValueWithPriority(memoryCache.getCurrentUser(), localCache.getCurrentUser());
    }

    /**
     * 按优先级返回值，前面的参数非空时才返回后面的
     *
     * @param vars
     * @param <T>
     * @return
     */
    private <T> T getValueWithPriority(T... vars) {
        for (T var : vars) {
            if (var != null) {
                return var;
            }
        }
        return null;
    }
}
