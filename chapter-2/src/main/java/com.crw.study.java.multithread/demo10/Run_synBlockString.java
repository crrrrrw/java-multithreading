package com.crw.study.java.multithread.demo10;

/**
 * P84
 * 不同对象监视器，运行结果是异步的
 */
public class Run_synBlockString {
    public static void main(String[] args) {
        /*Service1 service1 = new Service1();
        ThreadA1 threadA1 = new ThreadA1(service1);
        threadA1.setName("A");
        threadA1.start();
        ThreadB1 threadB1 = new ThreadB1(service1);
        threadB1.setName("B");
        threadB1.start();*/
        Service2 service2 = new Service2();
        ThreadA2 threadA2 = new ThreadA2(service2);
        threadA2.setName("A");
        threadA2.start();
        ThreadB2 threadB2 = new ThreadB2(service2);
        threadB2.setName("B");
        threadB2.start();
    }

}


/*
threadB1.start();
输出：
线程名称为：A在1507982366077进入同步代码块
线程名称为：A在1507982369078离开同步代码块
线程名称为：B在1507982369078进入同步代码块
线程名称为：B在1507982372078离开同步代码块

---------------------------------------
threadB2.start();
输出：
线程名称为：A在1507982642591进入同步代码块
线程名称为：B在1507982642591进入同步代码块
线程名称为：B在1507982645591离开同步代码块
线程名称为：A在1507982645591离开同步代码块
 */