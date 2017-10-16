package com.crw.study.java.multithread.demo4;

/**
 * p152
 * wait(long)使用，时间限制内由其他线程唤醒
 */
public class Run_waitHasParam2 {
    static private Object lock = new Object();
    static private Runnable runnable1 = new Runnable() {
        public void run() {
            try {
                synchronized (lock) {
                    System.out.println("wait begin timer=" + System.currentTimeMillis());
                    lock.wait(5000);
                    System.out.println("wait end timer=" + System.currentTimeMillis());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    static private Runnable runnable2 = new Runnable() {
        public void run() {

            synchronized (lock) {
                System.out.println("notify begin timer=" + System.currentTimeMillis());
                lock.notify();
                System.out.println("notify end timer=" + System.currentTimeMillis());
            }

        }
    };

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(runnable1);
        t1.start();
        Thread.sleep(2000);
        Thread t2 = new Thread(runnable2);
        t2.start();
    }
}


/*
输出：
wait begin timer=1508164573421
notify begin timer=1508164575421
notify end timer=1508164575421
wait end timer=1508164575421
 */