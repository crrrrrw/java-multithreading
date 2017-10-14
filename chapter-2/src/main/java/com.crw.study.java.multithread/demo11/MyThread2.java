package com.crw.study.java.multithread.demo11;

public class MyThread2 extends Thread {

    private MyOnelist list;

    public MyThread2(MyOnelist list) {
        super();
        this.list = list;
    }

    @Override
    public void run() {
        MyService msRef = new MyService();
        msRef.addServiceMethod(list, "B");
    }
}
