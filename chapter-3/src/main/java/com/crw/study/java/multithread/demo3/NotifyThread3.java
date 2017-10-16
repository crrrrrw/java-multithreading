package com.crw.study.java.multithread.demo3;

public class NotifyThread3 extends Thread {
    private Object lock;

    public NotifyThread3(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            lock.notifyAll();
        }
    }
}
