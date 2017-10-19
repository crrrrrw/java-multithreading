package com.crw.study.java.multithread.demo8;

/**
 * P228
 * 测试方法 void lockInterruptibly()
 * 作用：如果当前线程未被中断，则获取锁定，如果已经被中断则出现异常。
 */
public class Run_lockInterruptibly2 {
    public static void main(String[] args) throws InterruptedException {
        final Service2 service = new Service2();
        Runnable runnable = new Runnable() {
            public void run() {
                service.waitMethod();
            }
        };

        Thread threadA = new Thread(runnable);
        threadA.setName("A");
        threadA.start();
        Thread.sleep(500);
        Thread threadB = new Thread(runnable);
        threadB.setName("B");
        threadB.start();
        threadB.interrupt();
        System.out.println("main end");

    }
}

/*
输出：
lock begin A
main end
java.lang.InterruptedException
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireInterruptibly(AbstractQueuedSynchronizer.java:1220)
	at java.util.concurrent.locks.ReentrantLock.lockInterruptibly(ReentrantLock.java:335)
	at com.crw.study.java.multithread.demo8.Service2.waitMethod(Service2.java:12)
	at com.crw.study.java.multithread.demo8.Run_lockInterruptibly2$1.run(Run_lockInterruptibly2.java:13)
	at java.lang.Thread.run(Thread.java:745)
lock end   A
-----------------------------

lock begin A
java.lang.InterruptedException
main end
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireInterruptibly(AbstractQueuedSynchronizer.java:1220)
	at java.util.concurrent.locks.ReentrantLock.lockInterruptibly(ReentrantLock.java:335)
	at com.crw.study.java.multithread.demo8.Service2.waitMethod(Service2.java:12)
	at com.crw.study.java.multithread.demo8.Run_lockInterruptibly2$1.run(Run_lockInterruptibly2.java:13)
	at java.lang.Thread.run(Thread.java:745)
lock end   A


 */