package com.crw.study.java.multithread.demo16;

/**
 * P198
 * 类InheritableThreadLocal使用，值继承再更改
 *
 * 注意：如果子线程在取值的同时，主线程将InheritableThreadLocal值进行更改，
 * 那么子线程取到的值还是旧值。
 */
public class Run_InheritableThreadLocalExt2 {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("在Main线程中取值=" + Tools.itl2.get());
                Thread.sleep(100);
            }
            Thread.sleep(5000);
            ThreadC c = new ThreadC();
            c.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
输出：
在Main线程中取值=1508334155640
在Main线程中取值=1508334155640
在Main线程中取值=1508334155640
在Main线程中取值=1508334155640
在Main线程中取值=1508334155640
在Main线程中取值=1508334155640
在Main线程中取值=1508334155640
在Main线程中取值=1508334155640
在Main线程中取值=1508334155640
在Main线程中取值=1508334155640
在ThreadC线程中取值=1508334155640我在子线程加的~
在ThreadC线程中取值=1508334155640我在子线程加的~
在ThreadC线程中取值=1508334155640我在子线程加的~
在ThreadC线程中取值=1508334155640我在子线程加的~
在ThreadC线程中取值=1508334155640我在子线程加的~
在ThreadC线程中取值=1508334155640我在子线程加的~
在ThreadC线程中取值=1508334155640我在子线程加的~
在ThreadC线程中取值=1508334155640我在子线程加的~
在ThreadC线程中取值=1508334155640我在子线程加的~
在ThreadC线程中取值=1508334155640我在子线程加的~
 */