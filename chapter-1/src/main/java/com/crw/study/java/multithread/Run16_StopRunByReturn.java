package com.crw.study.java.multithread;

/**
 * p36 使用return 停止线程
 */
public class Run16_StopRunByReturn {
    public static void main(String[] args) throws InterruptedException {
        MyThread16 myThread16 = new MyThread16();
        myThread16.start();
        Thread.sleep(2000);
        myThread16.interrupt();
    }
}

class MyThread16 extends Thread {
    @Override
    public void run() {
        while (true) {
            if(this.isInterrupted()) {
                System.out.println("停止了！");
                return;
            }
            System.out.println("timer=" + System.currentTimeMillis());
        }
    }
}
/*
输出：
timer=1506151338428
timer=1506151338428
timer=1506151338428
timer=1506151338428
timer=1506151338428
timer=1506151338428
停止了！
 */
/*
不过还是建议使用“抛异常”的方式来停止线程，因为在catch语句块中可以对异常的信息进行相关
的处理，而且使用异常流能更好、更方便的控制程序的运行流程，不至于代码中出现很多return;造成污染。
 */