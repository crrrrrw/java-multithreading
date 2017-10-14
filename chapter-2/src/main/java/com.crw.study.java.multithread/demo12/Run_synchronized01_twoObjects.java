package com.crw.study.java.multithread.demo12;

/**
 * P93
 * 不同的“对象监视器”
 */
public class Run_synchronized01_twoObjects {
    public static void main(String[] args) {
        Service service = new Service();
        MyObject object1 = new MyObject();
        MyObject object2 = new MyObject();

        MyThread a = new MyThread(service, object1);
        a.setName("a");
        a.start();
        MyThread b = new MyThread(service, object2);
        b.setName("b");
        b.start();

    }
}

/*
输出：
testMethod1   ____getLock time=1507985141563 run ThreadName=a
testMethod1   ____getLock time=1507985141563 run ThreadName=b
testMethod1   releaseLock time=1507985143563 run ThreadName=a
testMethod1   releaseLock time=1507985143563 run ThreadName=b

 */