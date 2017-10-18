package com.crw.study.java.multithread.demo7;

import java.util.concurrent.locks.ReentrantLock;

public class Service1 {
    private ReentrantLock lock;

    public Service1(boolean isFair) {
        lock = new ReentrantLock(isFair);
    }

    public void serviceMethod() {
        try {
            lock.lock();
            System.out.println("公平锁情况：" + lock.isFair());
        } finally {
            lock.unlock();
        }
    }
}
