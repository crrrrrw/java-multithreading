package com.crw.study.java.multithread.demo12;

public class Thread1 extends Thread {
    private MyObject1 object1;

    public Thread1(MyObject1 object1) {
        this.object1 = object1;
    }

    @Override
    public void run() {
        super.run();
        object1.speedPrintString();
    }
}
