package com.crw.study.java.multithread.demo1;

/**
 * P207
 * 正确使用Condition实现等待通知
 * Object类的wait()------Condition类的await()
 * Object类的wait(long timeout)------Condition类的await(long time,TimeUnit unit)
 * Object类的notify()------Condition类的signal()
 * Object类的notifyAll()------Condition类的signalAll()
 */
public class Run_UseConditionWaitNotifyOk {
    public static void main(String[] args) throws InterruptedException {
        ServiceC service = new ServiceC();
        ThreadC c = new ThreadC(service);
        c.start();
        Thread.sleep(3000);
        service.signal();
    }
}


/*
输出：
await 时间为1508336307842
signal时间为1508336310842
signal锁释放了
 */