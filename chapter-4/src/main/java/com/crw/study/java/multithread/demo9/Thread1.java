package com.crw.study.java.multithread.demo9;

public class Thread1 extends Thread {
    private Service1 service;

    public Thread1(Service1 service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
