package com.quanshu.exchange.support.utils;

import android.widget.Toast;

import com.quanshu.exchange.ui.base.MyApplication;

public class ToastUtil {

    public static void toast(String msg) {
        Toast.makeText(MyApplication.getInstance(), msg, Toast.LENGTH_SHORT).show();
    }
}
