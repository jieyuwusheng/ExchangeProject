package com.quanshu.exchange.support.net.core;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import rx.Scheduler;
import rx.schedulers.Schedulers;

public class BaseScheduler {

    //核心有2个线程，最大线程数量为20，存活时间60s
    private static Scheduler scheduler;

    public static Scheduler getScheduler() {
        if (scheduler == null) {
            scheduler = Schedulers.from(new ThreadPoolExecutor(2, 20, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>()));

        }
        return scheduler;
    }
}
