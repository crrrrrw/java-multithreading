package com.crw.study.java.multithread.demo15;

/**
 * P185
 * join(long)和sleep(long)的区别
 * sleep(long)方法不释放锁
 */
public class Run_join_sleep {
    public static void main(String[] args) {
        try {
            ThreadB b = new ThreadB();
            ThreadA a = new ThreadA(b);
            a.start();
            Thread.sleep(1000);
            ThreadC c = new ThreadC(b);
            c.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
输出：
b run begin timer=1508250041793
b run end timer=1508250046793
打印了bService timer=1508250047793



 */