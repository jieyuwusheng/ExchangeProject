package com.quanshu.exchange;

import com.quanshu.exchange.support.api.base.BaseResponse;
import com.quanshu.exchange.support.entity.User;
import com.quanshu.exchange.support.net.NetClient;
import com.quanshu.exchange.support.net.core.BaseSubscriber;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testNetClient() throws Exception {

        NetClient.getInstance()
                .getLoginApi()
                .login("quanshu", "jieyuwusheng", "123456")
                .subscribe(new BaseSubscriber<BaseResponse<User>>() {
                    @Override
                    public void onSuccess(BaseResponse<User> response) {


                    }
                });
    }

}