package com.crw.study.java.multithread.demo7;

/**
 * P225
 * 测试方法boolean isHeldByCurrentThread()
 * 查询当前线程是否保持此锁定
 */
public class Run_isHeldByCurrentThread {
    public static void main(String[] args) {
        final Service2 service = new Service2(true);
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