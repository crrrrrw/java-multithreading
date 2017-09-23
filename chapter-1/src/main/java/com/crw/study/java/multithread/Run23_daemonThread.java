package com.crw.study.java.multithread;

/**
 * 守护线程：线程分守护线程和用户线程。当进程中不存在非守护线程了，守护线程就会自动销毁。
 * 比如垃圾回收线程。当jvm中非守护线程没有结束，守护线程就要工作。
 */
public class Run23_daemonThread {
    public static void main(String[] args) {
        try {
            MyThread22 myThread22 = new MyThread22();
            myThread22.setDaemon(true);
            myThread22.start();
            Thread.sleep(5000);
            System.out.println("我离开，myThread22对象也不再打印了，也就是停止了！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread22 extends Thread {
    private int i = 0;
    @Override
    public void run() {
        try {
            while (true) {
                i++;
                System.out.println("i=" + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
输出：
i=1
i=2
i=3
i=4
i=5
i=6
我离开了myThread22对象也不再打印了，也就是停止了！
 */