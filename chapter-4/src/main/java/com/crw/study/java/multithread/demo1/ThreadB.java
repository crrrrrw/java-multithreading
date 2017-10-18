package com.crw.study.java.multithread.demo1;

public class ThreadB extends Thread {
    private ServiceB service;

    public ThreadB(ServiceB service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.waitMethod();
    }
}
