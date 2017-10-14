package com.crw.study.java.multithread.demo12;

public class MyThread extends Thread {
    private Service service;
    private MyObject object;

    public MyThread(Service service, MyObject object) {
        super();
        this.object = object;
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.testMethod1(object);
    }
}
