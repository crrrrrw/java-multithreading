package com.crw.study.java.multithread.demo2;

/**
 * P210
 * 使用多个condition实现通知部分线程
 */
public class Run_MustUseMoreCondition {
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
        Thread.sleep(3000);
        service.signalAll_A();
    }
}


/*
输出：
awaitA begin时间为1508336447397 ThreadName=A
awaitB begin时间为1508336447397 ThreadName=B
signalAll_A 时间为1508336450396 ThreadName=main
awaitA end  时间为1508336450396 ThreadName=A
A锁释放了  时间为1508336450396 ThreadName=A
 */