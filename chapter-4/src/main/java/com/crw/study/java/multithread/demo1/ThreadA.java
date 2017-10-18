package com.crw.study.java.multithread.demo1;

public class ThreadA extends Thread {
    private ServiceA service;

    public ThreadA(ServiceA service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.await();
    }
}
