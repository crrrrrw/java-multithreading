package com.crw.study.java.multithread;

/**
 * P23
 * 停止线程 interrupt()方法仅仅是在当前线程打了一个停止标记，并不是真的停止线程
 */

class MyThread9 extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            /*try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            System.out.println("i=" + (i + 1));
        }
    }
}

public class Run7_interrupt {
    public static void main(String[] args) {
        try {
            MyThread9 myThread9 = new MyThread9();
            myThread9.start();
            Thread.sleep(2000);
            myThread9.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }

    }
}

/*
run 方法如果加入sleep,则输出节选：
i=20
i=21
java.lang.InterruptedException: sleep interrupted
	at java.lang.Thread.sleep(Native Method)
	at com.crw.study.java.multithread.MyThread9.run(Run7_interrupt.java:14)
i=22
i=23
省略...

 */
/*
为什么会抛异常？
源码：
```
    public void interrupt() {
        if (this != Thread.currentThread())
            checkAccess();

        synchronized (blockerLock) {
            Interruptible b = blocker;
            if (b != null) {
                interrupt0();           // Just to set the interrupt flag
                b.interrupt(this);
                return;
            }
        }
        interrupt0();
    }
```

如果当前线程没有中断它自己（这在任何情况下都是允许的），则该线程的 checkAccess 方法就会被调用，这可能抛出 SecurityException。

如果线程在调用 Object 类的 wait()、wait(long) 或 wait(long, int) 方法，或者该类的 join()、join(long)、join(long, int)、sleep(long) 或 sleep(long, int) 方法过程中受阻，则其中断状态将被清除，它还将收到一个 InterruptedException。

如果该线程在可中断的通道上的 I/O 操作中受阻，则该通道将被关闭，该线程的中断状态将被设置并且该线程将收到一个 ClosedByInterruptException。

如果该线程在一个 Selector 中受阻，则该线程的中断状态将被设置，它将立即从选择操作返回，并可能带有一个非零值，就好像调用了选择器的 wakeup 方法一样。

如果以前的条件都没有保存，则该线程的中断状态将被设置。
 */