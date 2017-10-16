package com.crw.study.java.multithread.demo5;

/**
 * P154
 * notify正常通知
 */
public class Run_notify {
    public static void main(String[] args) throws InterruptedException {
        MyRun myRun = new MyRun();
        Thread a = new Thread(myRun.runnableWait);
        a.start();
        Thread.sleep(100);
        Thread b = new Thread(myRun.runnableNotify);
        b.start();
    }

}

/*
输出：
wait begin timer=1508164790366
notify begin timer=1508164790467
notify end timer=1508164790467
wait end timer=1508164790467
 */