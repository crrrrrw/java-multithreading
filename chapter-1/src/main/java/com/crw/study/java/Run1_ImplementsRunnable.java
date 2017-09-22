package com.crw.study.java;

/**
 * 使用多线程之实现Runnable接口
 */
public class Run1_ImplementsRunnable {
    public static void main(String[] args) {
        // 1.使用Runnable接口解决单继承局限性
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        System.out.println("运行结束");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("运行中");
    }
}
