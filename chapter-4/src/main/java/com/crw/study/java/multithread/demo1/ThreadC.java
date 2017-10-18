package com.crw.study.java.multithread.demo1;

public class ThreadC extends Thread {
    private ServiceC service;

    public ThreadC(ServiceC service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.await();
    }
}
