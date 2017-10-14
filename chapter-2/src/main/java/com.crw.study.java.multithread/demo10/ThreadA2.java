package com.crw.study.java.multithread.demo10;

public class ThreadA2 extends Thread {
    private Service2 service;

    public ThreadA2(Service2 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.setUsernamePassword("a", "aa");
    }
}
