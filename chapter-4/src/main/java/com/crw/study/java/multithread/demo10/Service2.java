package com.crw.study.java.multithread.demo10;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 这里为什么用双try?
 * 以前不都是直接try catch finally的吗？
 */
public class Service2 {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void write() {
        try {
            try {
                lock.writeLock().lock();
                System.out.println("获得写锁" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
                Thread.sleep(10000);
            } finally {
                lock.writeLock().unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
