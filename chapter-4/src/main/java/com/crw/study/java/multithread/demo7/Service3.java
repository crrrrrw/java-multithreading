package com.crw.study.java.multithread.demo7;

import java.util.concurrent.locks.ReentrantLock;

public class Service3 {
    private ReentrantLock lock;

    public Service3(boolean isFair) {
        lock = new ReentrantLock(isFair);
    }

    public void serviceMethod() {
        try {
            System.out.println(lock.isLocked());
            lock.lock();
            System.out.println(lock.isLocked());
        } finally {
            lock.unlock();
        }
    }
}
