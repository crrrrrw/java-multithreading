package com.crw.study.java.multithread.demo8;

public class ThreadP extends Thread {
    private Producer p;

    public ThreadP(Producer p) {
        super();
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            p.setValue();
        }
    }
}
