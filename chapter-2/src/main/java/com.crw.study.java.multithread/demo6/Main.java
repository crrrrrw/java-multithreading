package com.crw.study.java.multithread.demo6;

public class Main {
    protected int i = 10;

    synchronized public void operateIinMain() {
        try {
            i--;
            System.out.println("main print i=" + i);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
