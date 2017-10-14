package com.crw.study.java.multithread.demo18;

import java.util.concurrent.atomic.AtomicLong;

public class MyService {

    public static AtomicLong aiRef = new AtomicLong(0);

    //synchronized
    public void addNum() {
        System.out.println(Thread.currentThread().getName() + "加了100以后的是："
        + aiRef.addAndGet(100));
        aiRef.addAndGet(1);
    }
}
