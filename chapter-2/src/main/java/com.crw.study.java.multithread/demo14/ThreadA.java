package com.crw.study.java.multithread.demo14;

public class ThreadA extends Thread {
    ServiceA serviceA;

    public ThreadA(ServiceA serviceA) {
        super();
        this.serviceA = serviceA;
    }

    @Override
    public void run() {
        serviceA.print("123");
    }
}
