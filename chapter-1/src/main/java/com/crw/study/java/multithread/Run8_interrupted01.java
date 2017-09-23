package com.crw.study.java.multithread;

/**
 * P25
 * 判断线程是否停止状态
 * 测试当前线程是否已经中断
 */
class MyThread10 extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i=" + (i + 1));
        }
    }
}

public class Run8_interrupted01 {
    public static void main(String[] args) {
        try {
            MyThread10 myThread10 = new MyThread10();
            myThread10.start();
            Thread.sleep(1000);
            myThread10.interrupt();
            System.out.println("Thread.interrupted()，是否停止1？=" + myThread10.interrupted());
            System.out.println("Thread.interrupted()，是否停止2？=" + myThread10.interrupted());
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end");
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
i=7
i=8
i=9
i=10
Thread.interrupted()，是否停止1？=false
Thread.interrupted()，是否停止2？=false
end
i=11
java.lang.InterruptedException: sleep interrupted
	at java.lang.Thread.sleep(Native Method)
	at com.crw.study.java.multithread.MyThread10.run(Run8_interrupted01.java:14)
i=12
i=13
省略....

-----------------


 */

/*
为什么两个布尔值都是false?
interrupted() ：测试**当前线程**是否已经中断
“当前线程”是main线程，所以并没有中断
 */