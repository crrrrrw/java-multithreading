package com.crw.study.java.multithread;

/**
 * P30
 * 睡眠中停止，先进入的sleep,再interrupt()
 */
class MyThread13 extends Thread {
    @Override
    public void run() {
        super.run();

        try {
            System.out.println("run begin");
            Thread.sleep(20000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("沉睡中被停止！进入catch!" + this.isInterrupted());
            e.printStackTrace();
        }
    }
}

public class Run13_sleepAndinterrupt01 {
    public static void main(String[] args) {
        try {
            MyThread13 myThread13 = new MyThread13();
            myThread13.start();
            Thread.sleep(200);
            myThread13.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end");
    }
}

/*
输出：
run begin
end
沉睡中被停止！进入catch!false
java.lang.InterruptedException: sleep interrupted
	at java.lang.Thread.sleep(Native Method)
	at com.crw.study.java.multithread.MyThread13.run(Run13_sleepAndinterrupt01.java:18)

-------
输出不唯一：
run begin
java.lang.InterruptedException: sleep interrupted
	at java.lang.Thread.sleep(Native Method)
	at com.crw.study.java.multithread.MyThread13.run(Run13_sleepAndinterrupt01.java:18)
end
沉睡中被停止！进入catch!false

*/
/*
从打印结果看，如果在Sleep状态下停止某一线程，会进入catch语句，并清除停止状态，使之变成false
 */