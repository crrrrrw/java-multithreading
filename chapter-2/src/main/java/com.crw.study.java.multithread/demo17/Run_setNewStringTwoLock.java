package com.crw.study.java.multithread.demo17;

/**
 * P114
 * 锁对象改变
 */
public class Run_setNewStringTwoLock {
    public static void main(String[] args) throws InterruptedException {
        final Service service = new Service();
        Thread a = new Thread() {
            @Override
            public void run() {
                service.testMethod();
            }
        };
        a.setName("A");
        Thread b = new Thread() {
            @Override
            public void run() {
                service.testMethod();
            }
        };
        b.setName("B");

        a.start();
        Thread.sleep(50);
        b.start();

    }
}


/*
输出：
A begin 1507988504308
B begin 1507988504357
A end 1507988506308
B end 1507988506357


--------------

//Thread.sleep(200);
输出：
A begin 1507988558378
A end 1507988558379
B begin 1507988558428
B end 1507988558428
 */