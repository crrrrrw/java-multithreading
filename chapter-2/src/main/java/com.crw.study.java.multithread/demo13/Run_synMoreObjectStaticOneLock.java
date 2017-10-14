package com.crw.study.java.multithread.demo13;

/**
 * P100
 * Class锁可以对类的所有对象实例起作用
 */
public class Run_synMoreObjectStaticOneLock {
    public static void main(String[] args) {
        Service service1 = new Service();
        Service service2 = new Service();

        ThreadA a = new ThreadA(service1);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(service2);
        b.setName("B");
        b.start();

    }
}

/*
输出：
线程名：A 在 1507985679426进入printA
线程名：A 在 1507985682427离开printA
线程名：B 在 1507985682427进入printB
线程名：B 在 1507985682427离开printB
 */
