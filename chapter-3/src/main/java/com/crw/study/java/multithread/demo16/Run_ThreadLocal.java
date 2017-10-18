package com.crw.study.java.multithread.demo16;

/**
 * P196
 * 验证线程变量的隔离性
 */
public class Run_ThreadLocal {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("在Main线程中取值=" + Tools.tl.get());
                Thread.sleep(100);
            }
            Thread.sleep(5000);
            ThreadA a = new ThreadA();
            a.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
输出：
在Main线程中取值=1508332195108
在Main线程中取值=1508332195108
在Main线程中取值=1508332195108
在Main线程中取值=1508332195108
在Main线程中取值=1508332195108
在Main线程中取值=1508332195108
在Main线程中取值=1508332195108
在Main线程中取值=1508332195108
在Main线程中取值=1508332195108
在Main线程中取值=1508332195108
在ThreadA线程中取值=1508332201120
在ThreadA线程中取值=1508332201120
在ThreadA线程中取值=1508332201120
在ThreadA线程中取值=1508332201120
在ThreadA线程中取值=1508332201120
在ThreadA线程中取值=1508332201120
在ThreadA线程中取值=1508332201120
在ThreadA线程中取值=1508332201120
在ThreadA线程中取值=1508332201120
在ThreadA线程中取值=1508332201120
 */