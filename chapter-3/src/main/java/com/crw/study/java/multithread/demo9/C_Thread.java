package com.crw.study.java.multithread.demo9;

public class C_Thread extends Thread {
    private Consumer c;

    public C_Thread(Consumer c) {
        super();
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            c.popService();
        }
    }
}
