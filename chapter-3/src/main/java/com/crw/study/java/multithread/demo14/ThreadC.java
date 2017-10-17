package com.crw.study.java.multithread.demo14;

public class ThreadC extends Thread {

    private ThreadB b;

    public ThreadC(ThreadB b) {
        super();
        this.b = b;
    }

    @Override
    public void run() {
        b.interrupt();
    }
}
