package com.crw.study.java;

/**
 * 使用多线程之继承Thread
 */
public class Run0_ExtendsThread {

    public static void main(String[] args) {
        // 1.创建多线程
        MyThread myThread = new MyThread();
        myThread.start();
        // myThread.start(); //如果多次调用start()方法会抛 Exception in thread "main" java.lang.IllegalThreadStateException
        System.out.println("运行结束！");

        System.out.println("===========华丽丽的分割线============");

        // 2.线程的随机性
        RandomThread thread = new RandomThread();
        thread.setName("RandomThread");
        thread.start();
        try {
            for (int i = 0; i < 10; i++) {
                int time = (int) Math.random();
                Thread.sleep(time);
                System.out.println("main=" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("===========华丽丽的分割线============");

        // 3.执行start()方法不代表线程启动的顺序
        for (int i = 0; i < 40; i++) {
            MyThread2 t = new MyThread2(i);
            t.start();
        }

    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("MyThread");
    }
}

class RandomThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int time = (int) Math.random();
                Thread.sleep(time);
                System.out.println("run=" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class MyThread2 extends Thread {
    private int i = 1;
    public MyThread2(int i) {
        this.i = i;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i);
    }
}