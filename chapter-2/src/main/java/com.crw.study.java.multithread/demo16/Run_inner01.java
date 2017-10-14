package com.crw.study.java.multithread.demo16;

/**
 * P112
 * 内置类和同步测试1：内置类两个同步方法使用不同的锁，结果异步
 */
import com.crw.study.java.multithread.demo16.OutClass.Inner;

public class Run_inner01 {
    public static void main(String[] args) {
        final Inner inner = new Inner();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                inner.method1();
            }
        }, "A");
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                inner.method2();
            }
        }, "B");
        t1.start();
        t2.start();
    }
}

/*
输出：
A i=1
B i=11
B i=12
A i=2
A i=3
B i=13
B i=14
A i=4
A i=5
B i=15
A i=6
B i=16
B i=17
A i=7
B i=18
A i=8
A i=9
B i=19
A i=10
B i=20

 */