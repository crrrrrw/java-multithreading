package com.crw.study.java.multithread.demo9;

public class Thread2 extends Thread {
    private Service2 service;

    public Thread2(Service2 service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
