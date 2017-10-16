package com.crw.study.java.multithread.demo6;

public class ThreadSubtract extends Thread {
    private Subtract subtract;

    public ThreadSubtract(String name, Subtract subtract) {
        super(name);
        this.subtract = subtract;
    }

    @Override
    public void run() {
        subtract.subtract();
    }
}
