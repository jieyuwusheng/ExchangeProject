package com.quanshu.exchange.support.api;

import com.quanshu.exchange.support.api.base.BaseResponse;
import com.quanshu.exchange.support.entity.User;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by jye on 2017/11/9.
 */

public interface LoginApi {

    /**
     * 登录
     */
    @FormUrlEncoded
    @POST("/apiJtoken/login")
    Observable<BaseResponse<User>> login(@Field("key") String key,
                                         @Field("username") String username,
                                         @Field("password") String password);

}