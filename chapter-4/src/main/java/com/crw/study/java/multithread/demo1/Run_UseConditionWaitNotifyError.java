package com.crw.study.java.multithread.demo1;

/**
 * P204
 * 使用Condition实现等待通知，展示错误用法
 * IllegalMonitorStateException，监视器出错
 *
 * 解决方法：必须在 condition.await() 调用之前调用 lock.locak() 代码获得同步监视器
 */
public class Run_UseConditionWaitNotifyError {
    public static void main(String[] args) {
        ServiceA service = new ServiceA();
        ThreadA a = new ThreadA(service);
        a.start();
    }
}


/*
输出：
Exception in thread "Thread-0" java.lang.IllegalMonitorStateException
	at java.util.concurrent.locks.ReentrantLock$Sync.tryRelease(ReentrantLock.java:151)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.release(AbstractQueuedSynchronizer.java:1261)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.fullyRelease(AbstractQueuedSynchronizer.java:1723)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2036)
	at com.crw.study.java.multithread.demo1.ServiceA.await(ServiceA.java:13)
	at com.crw.study.java.multithread.demo1.ThreadA.run(ThreadA.java:12)

 */