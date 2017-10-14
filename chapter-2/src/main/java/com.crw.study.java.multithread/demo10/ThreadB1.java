package com.crw.study.java.multithread.demo10;

public class ThreadB1 extends Thread {
    private Service1 service;

    public ThreadB1(Service1 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.setUsernamePassword("b", "bb");
    }
}
