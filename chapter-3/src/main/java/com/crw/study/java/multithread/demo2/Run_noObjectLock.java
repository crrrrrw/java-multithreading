package com.crw.study.java.multithread.demo2;

/**
 * P137
 * 没有“对象监视器”，调用wait()方法出现运行时异常
 */
public class Run_noObjectLock {
    public static void main(String[] args) {
        String s = new String("");
        try {
            s.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
输出：
Exception in thread "main" java.lang.IllegalMonitorStateException
	at java.lang.Object.wait(Native Method)
	at java.lang.Object.wait(Object.java:502)
	at com.crw.study.java.multithread.demo2.Run_noObjectLock.main(Run_noObjectLock.java:11)
 */