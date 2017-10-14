package com.crw.study.java.multithread.demo12;

public class Thread2 extends Thread {
    private MyObject2 object2;

    public Thread2(MyObject2 object2) {
        this.object2 = object2;
    }

    @Override
    public void run() {
        super.run();
        object2.speedPrintString();
    }
}
