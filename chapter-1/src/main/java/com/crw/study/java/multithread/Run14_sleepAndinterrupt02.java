package com.crw.study.java.multithread;

/**
 * P31例子
 * 先interrupt(),再进入sleep(),直接进异常
 */
class MyThread14 extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 100000; i++) {
                System.out.println("i=" + (i + 1));
            }
            System.out.println("run begin");
            Thread.sleep(200000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("先停止，再遇到了sleep！进入catch");
            e.printStackTrace();
        }
    }
}

public class Run14_sleepAndinterrupt02 {
    public static void main(String[] args) {
        MyThread14 myThread14 = new MyThread14();
        myThread14.start();
        myThread14.interrupt();
        System.out.println("end！");
    }
}

/*
输出：
end！
i=1
i=2
i=3
i=4
省略。。。

i=99998
i=99999
i=100000
run begin
先停止，再遇到了sleep！进入catch
java.lang.InterruptedException: sleep interrupted
	at java.lang.Thread.sleep(Native Method)
	at com.crw.study.java.multithread.MyThread14.run(Run14_sleepAndinterrupt02.java:20)

 */
/*
此处关于 interrupt() 的相关在 Run7_interrupt.java 中有详细解释
 */