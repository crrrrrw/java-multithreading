package com.crw.study.java.multithread;

/**
 * P43例子
 * 线程优先级的继承性
 */

class MyThread20_1 extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread20_1 run priority=" + this.getPriority());
        MyThread20_2 myThread20_2 = new MyThread20_2();
        myThread20_2.start();

    }
}

class MyThread20_2 extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread20_2 run priority=" + this.getPriority());
    }
}

public class Run21_priority01 {
    public static void main(String[] args) {
        System.out.println("main thread begin priority =" + Thread.currentThread().getPriority());
        //Thread.currentThread().setPriority(6);
        System.out.println("main thread end priority =" + Thread.currentThread().getPriority());
        MyThread20_1 myThread20_1 = new MyThread20_1();
        myThread20_1.start();
    }
}

/*
//Thread.currentThread().setPriority(6);
输出：
main thread begin priority =5
main thread end priority =5
MyThread20_1 run priority=5
MyThread20_2 run priority=5

--------------------

Thread.currentThread().setPriority(6);
输出：
main thread begin priority =5
main thread end priority =6
MyThread20_1 run priority=6
MyThread20_2 run priority=6

 */
