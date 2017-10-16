package com.crw.study.java.multithread.demo6;

public class ThreadAdd extends Thread {
    private Add add;

    public ThreadAdd(String name, Add add) {
        super(name);
        this.add = add;
    }

    @Override
    public void run() {
        add.add();
    }
}
