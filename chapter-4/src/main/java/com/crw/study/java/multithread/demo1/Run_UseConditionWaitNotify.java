package com.crw.study.java.multithread.demo1;

/**
 * P206
 * 使用Condition实现等待通知
 * Condition对象的await()方法，线程WAITING
 */
public class Run_UseConditionWaitNotify {
    public static void main(String[] args) {
        ServiceB service = new ServiceB();
        ThreadB b = new ThreadB(service);
        b.start();
    }
}


/*
输出：
A
 */