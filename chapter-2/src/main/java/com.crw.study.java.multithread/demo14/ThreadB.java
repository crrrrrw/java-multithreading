package com.crw.study.java.multithread.demo14;

public class ThreadB extends Thread {
    ServiceB serviceB;

    public ThreadB(ServiceB serviceB) {
        super();
        this.serviceB = serviceB;
    }

    @Override
    public void run() {
        serviceB.print(new Object());
    }
}
