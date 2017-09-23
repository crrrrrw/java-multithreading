package com.crw.study.java.multithread;

/**
 * p33 使用stop()方法暴力停止，以及 java.lang.ThreadDeath 异常
 */
public class Run15_StopRunByStopMethod {
    public static void main(String[] args) {
        MyThread15 myThread15 = new MyThread15();
        myThread15.start();
    }
}
class MyThread15 extends Thread {
    @Override
    public void run() {
        try {
            this.stop();
        } catch (ThreadDeath e) {
            System.out.println("进入catch()方法了！");
            e.printStackTrace();
        }
    }
}
/*
输出：
java.lang.ThreadDeath
进入catch()方法了！
	at java.lang.Thread.stop(Thread.java:850)
	at com.crw.study.java.multithread.MyThread15.run(Run15_StopRunByStopMethod.java:16)
*/
/*
调用stop()方法时会抛出java.lang.ThreadDeath 异常,但通常情况下，此异常不需要显示的捕获。

方法stop()已经被作废，因为如果强制让线程停止有可能使一些请理性的工作得不到完成。另一个情况
就是对锁定的对象进行了“解锁”，导致数据得不到同步处理，出现数据不一致的问题。
 */
