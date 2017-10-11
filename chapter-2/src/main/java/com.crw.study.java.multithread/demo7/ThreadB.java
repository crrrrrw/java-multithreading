package com.crw.study.java.multithread.demo7;

public class ThreadB extends Thread {
    private Service service;

    public ThreadB(String name, Service service) {
        super(name);
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
