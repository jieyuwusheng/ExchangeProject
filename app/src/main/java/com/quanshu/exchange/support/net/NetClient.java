package com.quanshu.exchange.support.net;

import android.support.annotation.NonNull;

import com.quanshu.exchange.support.api.LoginApi;
import com.quanshu.exchange.support.config.WebConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * 统一接口调度
 *
 */
public class NetClient {

    public static volatile NetClient instance;

    public LoginApi getLoginApi() {
        return loginApi;
    }

    private LoginApi loginApi;

    private final OkHttpClient okHttpClient;

    public static NetClient getInstance() {
        //第一层避免不必要的线程同步
        if (instance == null) {
            synchronized (NetClient.class) {
                //第二层为空则创建实例
                if (instance == null) {
                    instance = new NetClient();
                }
            }
        }
        return instance;
    }

    /**
     * 创建网络辅助类
     */
    protected NetClient() {
        okHttpClient = createOkHttpClient();
        initNetInterface();
    }

    /**
     * 创建OkHttpClient客户端
     *
     * @return
     */
    @NonNull
    protected OkHttpClient createOkHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
//                .addInterceptor(new HeaderInterceptor(cache))
                .addInterceptor(logging)
                .build();
    }


    /**
     * 初始化应用中各个模块的网络接口
     */
    protected void initNetInterface() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WebConfig.HOST_OFFICIAL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        loginApi = retrofit.create(LoginApi.class);

    }

}
