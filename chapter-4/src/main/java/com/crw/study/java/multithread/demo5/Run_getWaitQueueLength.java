package com.crw.study.java.multithread.demo5;

/**
 * P221
 * 测试方法int getWaitQueueLength(Condition condition)
 * 返回等待与此锁定相关的给定条件Condition的线程估计数
 * 比如有5个线程，每个线程都执行了同一个condition对象的await()方法，
 * 则调用getWaitQueueLength(Condition condition)方法返回的值是5
 */
public class Run_getWaitQueueLength {
    public static void main(String[] args) throws InterruptedException {
        final Service3 service = new Service3();
        Runnable runnable = new Runnable() {
            public void run() {
                service.waitMethod();
            }
        };

        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(runnable);
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }

        Thread.sleep(2000);

        service.notifyMethod();
    }
}


/*
输出：

before await Thread-0
before await Thread-5
before await Thread-3
before await Thread-8
before await Thread-1
before await Thread-2
before await Thread-4
before await Thread-6
before await Thread-7
before await Thread-9
有10个线程正在等待newCondition
after  await Thread-0
 */