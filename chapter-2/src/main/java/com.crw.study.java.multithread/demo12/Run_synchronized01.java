package com.crw.study.java.multithread.demo12;

/**
 * P91
 * synchronized(非this对象x)的三个结论
 * 1）当多个线程同时执行synchronized(x){}同步代码块时呈现效果
 * 2）当其他线程执行x对象中synchronized同步方法时呈同步效果
 * 3）当其他线程执行x对象里面的synchronized(this)代码块时，也呈现同步效果
 * 验证结论1：
 * 当多个线程同时执行synchronized(x){}同步代码块时呈现效果
 */
public class Run_synchronized01 {
    public static void main(String[] args) {
        Service service = new Service();
        MyObject object = new MyObject();

        MyThread a = new MyThread(service, object);
        a.setName("a");
        a.start();
        MyThread b = new MyThread(service, object);
        b.setName("b");
        b.start();

    }
}

/*
输出：
testMethod1   ____getLock time=1507985077666 run ThreadName=a
testMethod1   releaseLock time=1507985079666 run ThreadName=a
testMethod1   ____getLock time=1507985079666 run ThreadName=b
testMethod1   releaseLock time=1507985081666 run ThreadName=b
 */