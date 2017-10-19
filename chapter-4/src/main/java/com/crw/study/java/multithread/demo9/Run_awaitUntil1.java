package com.crw.study.java.multithread.demo9;

/**
 * P233
 * 测试方法awaitUntil()
 * 到达等待时间可唤醒自己
 */
public class Run_awaitUntil1 {
    public static void main(String[] args) {
        Service service = new Service();
        ThreadA threadA = new ThreadA(service);
        threadA.start();
    }
}


/*
输出：
wait begin timer=1508424252130
wait end   timer=1508424262128
 */