package com.crw.study.java.multithread.demo8;

public class MyThread extends Thread {
    private Sub sub;

    public MyThread(Sub sub) {
        super();
        this.sub = sub;
    }

    @Override
    public void run() {
        sub.testMethod();
    }
}
