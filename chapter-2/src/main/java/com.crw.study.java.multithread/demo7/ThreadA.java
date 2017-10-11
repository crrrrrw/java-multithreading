package com.crw.study.java.multithread.demo7;

public class ThreadA extends Thread {
    private Service service;

    public ThreadA(String name, Service service) {
        super(name);
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
