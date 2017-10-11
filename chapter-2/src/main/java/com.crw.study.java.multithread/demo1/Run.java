package com.crw.study.java.multithread.demo1;

/**
 * P53例子
 * 方法内局部变量为线程安全的，这是方法内部的变量是私有的特性造成的
 */

public class Run {
    public static void main(String[] args) {
        HasSelfPrivateNum numRef = new HasSelfPrivateNum();
        ThreadA threadA = new ThreadA(numRef);
        threadA.start();
        ThreadB threadB = new ThreadB(numRef);
        threadB.start();
    }
}


/*
输出：
a set over
b set over
b num= 200
a num= 100
*/