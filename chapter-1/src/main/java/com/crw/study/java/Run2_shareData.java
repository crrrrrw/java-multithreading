package com.crw.study.java;

/**
 * P11数据共享的例子.
 */
public class Run2_shareData {

    public static void main(String[] args) {
        // 1. 不共享数据例子
        // 三个线程各自操作自己的count
        MyThread3 aa = new MyThread3("AA");
        MyThread3 bb = new MyThread3("BB");
        MyThread3 cc = new MyThread3("CC");
        aa.start();
        bb.start();
        cc.start();

        // 2. 数据共享例子 非线程安全
        // 多线程操作同意变量
        MyThread4 myThread = new MyThread4();
        Thread a = new Thread(myThread, "A");
        Thread b = new Thread(myThread, "B");
        Thread c = new Thread(myThread, "C");
        Thread d = new Thread(myThread, "D");
        Thread e = new Thread(myThread, "E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();

        // 2. 数据共享例子 线程安全
        // 多线程操作同意变量
        MyThread5 myThread2 = new MyThread5();
        Thread aaa = new Thread(myThread2, "AAA");
        Thread bbb = new Thread(myThread2, "BBB");
        Thread ccc = new Thread(myThread2, "CCC");
        Thread ddd = new Thread(myThread2, "DDD");
        Thread eee = new Thread(myThread2, "EEE");
        aaa.start();
        bbb.start();
        ccc.start();
        ddd.start();
        eee.start();
    }
}

/**
 * 不共享数据线程
 */
class MyThread3 extends Thread {
    private int count = 5;

    public MyThread3(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("由" + this.currentThread().getName() + "  计算,count=" + count);
        }
    }
}

/**
 * 共享数据线程（线程不安全）
 */
class MyThread4 extends Thread {
    private int count = 5;

    @Override
    public void run() {
        super.run();
        count--;
        System.out.println("由" + this.currentThread().getName() + "  计算,count=" + count);
    }
}

/**
 * 共享数据线程(线程安全)
 */
class MyThread5 extends Thread {
    private int count = 5;

    @Override
    synchronized public void run() {
        super.run();
        count--;
        System.out.println("由" + this.currentThread().getName() + "  计算,count=" + count);
    }
}
