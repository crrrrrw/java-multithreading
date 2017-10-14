package com.crw.study.java.multithread.demo19;

/**
 * P121
 * 不使用volatile关键字
 * JVM配置 -server(IDEA15.02，jdk1.8,WIN7,64bit不加效果也是的)
 * 不使用volatile：线程一直在私有堆栈中取得isRunning = true;
 * 而代码 t.setRunning(false);虽然执行了，但更新的却是公共堆栈中的sRunning = false;所以死循环了。
 */
public class Run_volatile {
    public static void main(String[] args) {
        try {
            RunThread t = new RunThread();
            t.start();
            Thread.sleep(1000);
            t.setRunning(false);
            System.out.println("已经赋值为false");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


/*
输出：
进入run了
已经赋值为false

--------------
加上volatile关键字后
输出：
进入run了
已经赋值为false
线程被停止了
 */