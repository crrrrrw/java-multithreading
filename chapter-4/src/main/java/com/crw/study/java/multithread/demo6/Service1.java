package com.crw.study.java.multithread.demo6;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Service1 {
    public ReentrantLock lock = new ReentrantLock();
    public Condition newCondition = lock.newCondition();

    public void waitMethod() {
        try {
            lock.lock();
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
