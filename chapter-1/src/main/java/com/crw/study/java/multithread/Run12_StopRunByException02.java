package com.crw.study.java.multithread;

/**
 * p29 通过抛异常停止程序继续运行
 */
public class Run12_StopRunByException02 {
    public static void main(String[] args) {
        try {
            MyThread12 myThread12 = new MyThread12();
            myThread12.start();
            Thread.sleep(1000);
            myThread12.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end");
    }
}

class MyThread12 extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 500000; i++) {
                if(this.isInterrupted()) {
                    System.out.println("已经是停止状态了！我要退出了！");
                    throw new InterruptedException();
                }
                System.out.println("i=" + (i + 1));
            }
            System.out.println("我在for下面");
        } catch (InterruptedException e) {
            System.out.println("进MyThread12.java类run方法中的catch了！");
            e.printStackTrace();
        }
    }
}
/*
输出截取：
i=229591
i=229592
i=229593
end
已经是停止状态了！我要退出了！
进MyThread12.java类run方法中的catch了！
java.lang.InterruptedException
	at com.crw.study.java.multithread.MyThread12.run(Run12_StopRunByException02.java:29)

 */