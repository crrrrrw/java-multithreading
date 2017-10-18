package com.crw.study.java.multithread.demo7;

import java.util.concurrent.locks.ReentrantLock;

public class Service2 {
    private ReentrantLock lock;

    public Service2(boolean isFair) {
        lock = new ReentrantLock(isFair);
    }

    public void serviceMethod() {
        try {
            System.out.println(lock.isHeldByCurrentThread());
            lock.lock();
            System.out.println(lock.isHeldByCurrentThread());
        } finally {
            lock.unlock();
        }
    }
}
