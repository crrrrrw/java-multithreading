package com.crw.study.java.multithread.demo4;


/**
 * P63
 * 两个线程访问同一个对象的不同方法
 * 1.一个方法有synchronized，一个没有。线程B可异步调用非synchronized类型方法
 * 2.两个都有synchronized。线程B需等待
 */
public class Run_synchronizedMethodLockObject2 {
    public static void main(String[] args) {
        MyObject object = new MyObject();
        ThreadA a = new ThreadA(object);
        a.setName("A");
        ThreadB b = new ThreadB(object);
        b.setName("B");
        a.start();
        b.start();
    }
}

/*
public void methodB()没加synchronized
输出：
begin methodA threadName=A
begin methodB threadName=B
B  endTime:1507730327752
A  endTime:1507730327752

-------------------

public void methodB()加synchronized
输出：
begin methodA threadName=A
A  endTime:1507730349993
begin methodB threadName=B
B  endTime:1507730354994

*/
/*
结论：
1).A线程先持有object对象的Lock锁，B线程可以以异步的方式调用object对象中的非synchronized类型的方法。
2).A线程先持有object对象的Lock锁，B线程如果这时调用object对象中的synchronized类型的方法则需等待，也就是同步。
 */