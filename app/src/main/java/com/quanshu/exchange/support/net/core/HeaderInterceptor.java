package com.quanshu.exchange.support.net.core;


import com.quanshu.exchange.support.cache.ICache;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {

    private ICache cache;

    public HeaderInterceptor(ICache cache) {
        this.cache = cache;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request request = original
                .newBuilder()
                .header("Accept-Charset", "utf-8")
                .method(original.method(), original.body())
                .build();
        return chain.proceed(request);
    }
}
