package com.crw.study.java.multithread.demo5;

/**
 * P219
 * 测试方法int getHoldCount()
 * 查询当前线程保持此锁定的个数，即调用lock()方法的次数
 */
public class Run_getHoldCount {
    public static void main(String[] args) {
        Service1 service = new Service1();
        service.serviceMethod1();
    }
}


/*
输出：
serviceMethod1 getHoldCount=1
serviceMethod2 getHoldCount=2
 */