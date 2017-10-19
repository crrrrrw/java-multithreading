package com.crw.study.java.multithread.demo10;

/**
 * P236
 * 类ReentrantReadWriteLock的使用：读读共享
 */
public class Run_ReadWriteLockBegin1 {
    public static void main(String[] args) {
        final Service1 service = new Service1();
        Thread a = new Thread() {
            @Override
            public void run() {
                service.read();
            }
        };
        Thread b = new Thread() {
            @Override
            public void run() {
                service.read();
            }
        };
        a.setName("A");
        a.start();
        b.setName("B");
        b.start();
    }
}


/*
输出：
获得读锁A 1508424772894
获得读锁B 1508424772905
 */