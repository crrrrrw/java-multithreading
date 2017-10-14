package com.crw.study.java.multithread.demo18;

public class MyThread2 extends Thread {
    private MyService myService;

    public MyThread2(MyService myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.addNum();
    }
}
