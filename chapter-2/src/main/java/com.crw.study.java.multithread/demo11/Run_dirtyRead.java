package com.crw.study.java.multithread.demo11;

/**
 * p90 同步代码块放在非同步 synchronized 方法中进行声明，
 * 并不能保证调用方法的线程的执行同步/顺序性，也就是线程调用方法的顺序是无序的。
 * 方法内虽然同步，但是容易出现“脏读”。
 *
 * 原因：两个线程异步的返回list的size大小。
 * 解决方式：对业务方法list参数的getSize()方法做“同步化”
 */
public class Run_dirtyRead {

    public static void main(String[] args) throws InterruptedException {
        MyOnelist list = new MyOnelist();
        MyThread1 thread1 = new MyThread1(list);
        thread1.setName("A");
        thread1.start();
        MyThread2 thread2 = new MyThread2(list);
        thread2.setName("B");
        thread2.start();
        Thread.sleep(6000);
        System.out.println("listSize:" + list.getSize());
    }
}
/*

输出：
listSize:2
 */