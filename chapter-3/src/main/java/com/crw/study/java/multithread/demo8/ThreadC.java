package com.crw.study.java.multithread.demo8;

public class ThreadC extends Thread {
    private Consumer c;

    public ThreadC(Consumer c) {
        super();
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            c.getValue();
        }
    }
}
