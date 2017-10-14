package com.crw.study.java.multithread.demo11;

public class MyThread1 extends Thread {

    private MyOnelist list;

    public MyThread1(MyOnelist list) {
        super();
        this.list = list;
    }

    @Override
    public void run() {
        MyService msRef = new MyService();
        msRef.addServiceMethod(list, "B");
    }
}
