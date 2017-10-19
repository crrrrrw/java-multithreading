package com.crw.study.java.multithread.demo9;

/**
 * P233
 * 测试方法awaitUntil()
 * 线程在等待时间到达前，可以被其他线程唤醒
 */
public class Run_awaitUntil2 {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        ThreadA threadA = new ThreadA(service);
        threadA.start();
        Thread.sleep(2000);
        ThreadB threadB = new ThreadB(service);
        threadB.start();
    }
}


/*
输出：
wait begin timer=1508424288920
notify begin timer=1508424290908
notify end   timer=1508424290908
wait end   timer=1508424290909
 */