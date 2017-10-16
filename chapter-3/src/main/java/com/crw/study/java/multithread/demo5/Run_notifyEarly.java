package com.crw.study.java.multithread.demo5;

/**
 * P154
 * notify通知过早
 */
public class Run_notifyEarly {
    public static void main(String[] args) throws InterruptedException {
        MyRun myRun = new MyRun();
        Thread b = new Thread(myRun.runnableNotify);
        b.start();
        Thread.sleep(100);
        Thread a = new Thread(myRun.runnableWait);
        a.start();
    }

}

/*
输出：
notify begin timer=1508164773249
notify end timer=1508164773249
 */