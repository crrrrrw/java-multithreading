package com.crw.study.java.multithread.demo7;

/**
 * P226
 * 测试方法boolean isLocked()
 * 查询此锁定是否由任意线程保持
 */
public class Run_isLocked {
    public static void main(String[] args) {
        final Service3 service = new Service3(true);
        Runnable runnable = new Runnable() {
            public void run() {
                service.serviceMethod();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}


/*
输出：
false
true
 */