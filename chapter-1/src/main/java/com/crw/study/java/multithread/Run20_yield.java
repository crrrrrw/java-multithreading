package com.crw.study.java.multithread;

/**
 * P42例子
 * 测试yield:放弃当前cpu资源
 */

class MyThread19 extends Thread {
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 50000000; i++) {
            Thread.yield();
            count = count + (i + 1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("用时:" + (endTime - beginTime) + "毫秒");
    }
}

public class Run20_yield {
    public static void main(String[] args) {
        MyThread19 myThread19 = new MyThread19();
        myThread19.start();
    }
}


/*
//Thread.yield();
输出:
用时:19毫秒

-----------------

Thread.yield();
输出:
用时:6541毫秒

 */