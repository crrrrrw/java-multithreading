package com.crw.study.java.multithread.demo10;

/**
 * P238
 * 类ReentrantReadWriteLock的使用：写写互斥
 */
public class Run_ReadWriteLockBegin2 {
    public static void main(String[] args) {
        final Service2 service = new Service2();
        Thread a = new Thread() {
            @Override
            public void run() {
                service.write();
            }
        };
        Thread b = new Thread() {
            @Override
            public void run() {
                service.write();
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
获得写锁B 1508424839686
获得写锁A 1508424849687
 */