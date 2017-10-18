package com.crw.study.java.multithread.demo3;

/**
 * P215
 * 实现生产者/消费者模式，多对多交替打印
 * signal()会假死
 * signalAll()
 */
public class Run_ConditionManyToMany {
    public static void main(String[] args) {
        MyService service = new MyService();
        ThreadA[] threadAs = new ThreadA[10];
        ThreadB[] threadBs = new ThreadB[10];
        for (int i = 0; i < 10; i++) {
            threadAs[i] = new ThreadA(service);
            threadBs[i] = new ThreadB(service);
            threadAs[i].start();
            threadBs[i].start();
        }
    }
}


/*
输出：
有可能★★连续  时间为1508336856014 ThreadName=Thread-16
打印☆          时间为1508336856014 ThreadName=Thread-19
get unlock      时间为1508336856014 ThreadName=Thread-19
有可能☆☆连续  时间为1508336856014 ThreadName=Thread-19
有可能☆☆连续  时间为1508336856014 ThreadName=Thread-5
打印★          时间为1508336856014 ThreadName=Thread-18
set unlock      时间为1508336856014 ThreadName=Thread-18
有可能★★连续  时间为1508336856014 ThreadName=Thread-18
有可能★★连续  时间为1508336856014 ThreadName=Thread-0
有可能★★连续  时间为1508336856014 ThreadName=Thread-6
有可能★★连续  时间为1508336856014 ThreadName=Thread-8
打印☆          时间为1508336856014 ThreadName=Thread-9
get unlock      时间为1508336856014 ThreadName=Thread-9
有可能☆☆连续  时间为1508336856014 ThreadName=Thread-9
有可能☆☆连续  时间为1508336856014 ThreadName=Thread-1
有可能☆☆连续  时间为1508336856014 ThreadName=Thread-7
有可能☆☆连续  时间为1508336856014 ThreadName=Thread-11
有可能☆☆连续  时间为1508336856014 ThreadName=Thread-13
打印★          时间为1508336856014 ThreadName=Thread-12
set unlock      时间为1508336856014 ThreadName=Thread-12
有可能★★连续  时间为1508336856014 ThreadName=Thread-12
有可能★★连续  时间为1508336856014 ThreadName=Thread-2
有可能★★连续  时间为1508336856014 ThreadName=Thread-10
打印☆          时间为1508336856014 ThreadName=Thread-3
get unlock      时间为1508336856014 ThreadName=Thread-3
有可能☆☆连续  时间为1508336856014 ThreadName=Thread-3
有可能☆☆连续  时间为1508336856014 ThreadName=Thread-15
有可能☆☆连续  时间为1508336856014 ThreadName=Thread-17
打印★          时间为1508336856014 ThreadName=Thread-4
set unlock      时间为1508336856014 ThreadName=Thread-4
有可能★★连续  时间为1508336856014 ThreadName=Thread-4
有可能★★连续  时间为1508336856014 ThreadName=Thread-14
有可能★★连续  时间为1508336856014 ThreadName=Thread-16
打印☆          时间为1508336856014 ThreadName=Thread-19
get unlock      时间为1508336856014 ThreadName=Thread-19
有可能☆☆连续  时间为1508336856014 ThreadName=Thread-19
有可能☆☆连续  时间为1508336856014 ThreadName=Thread-5
打印★          时间为1508336856014 ThreadName=Thread-18
set unlock      时间为1508336856014 ThreadName=Thread-18
有可能★★连续  时间为1508336856014 ThreadName=Thread-18
有可能★★连续  时间为1508336856014 ThreadName=Thread-0
有可能★★连续  时间为1508336856014 ThreadName=Thread-6
有可能★★连续  时间为1508336856014 ThreadName=Thread-8
打印☆          时间为1508336856014 ThreadName=Thread-9
get unlock      时间为1508336856014 ThreadName=Thread-9
有可能☆☆连续  时间为1508336856014 ThreadName=Thread-9
有可能☆☆连续  时间为1508336856014 ThreadName=Thread-1
有可能☆☆连续  时间为1508336856014 ThreadName=Thread-7
有可能☆☆连续  时间为1508336856014 ThreadName=Thread-11
有可能☆☆连续  时间为1508336856014 ThreadName=Thread-13
打印★          时间为1508336856014 ThreadName=Thread-12
set unlock      时间为1508336856014 ThreadName=Thread-12
有可能★★连续  时间为1508336856014 ThreadName=Thread-12
有可能★★连续  时间为1508336856014 ThreadName=Thread-2
有可能★★连续  时间为1508336856014 ThreadName=Thread-10
打印☆          时间为1508336856014 ThreadName=Thread-3
get unlock      时间为1508336856014 ThreadName=Thread-3
有可能☆☆连续  时间为1508336856014 ThreadName=Thread-3
有可能☆☆连续  时间为1508336856014 ThreadName=Thread-15
有可能☆☆连续  时间为1508336856014 ThreadName=Thread-17
打印★          时间为1508336856014 ThreadName=Thread-4
set unlock      时间为1508336856014 ThreadName=Thread-4
有可能★★连续  时间为1508336856014 ThreadName=Thread-4
有可能★★连续  时间为1508336856014 ThreadName=Thread-14
有可能★★连续  时间为1508336856014 ThreadName=Thread-16
打印☆          时间为1508336856014 ThreadName=Thread-19
get unlock      时间为1508336856014 ThreadName=Thread-19
有可能☆☆连续  时间为1508336856014 ThreadName=Thread-19
有可能☆☆连续  时间为1508336856014 ThreadName=Thread-5
打印★          时间为1508336856014 ThreadName=Thread-18
set unlock      时间为1508336856014 ThreadName=Thread-18
有可能★★连续  时间为1508336856014 ThreadName=Thread-18
有可能★★连续  时间为1508336856014 ThreadName=Thread-0
有可能★★连续  时间为1508336856014 ThreadName=Thread-6
有可能★★连续  时间为1508336856014 ThreadName=Thread-8
打印☆          时间为1508336856014 ThreadName=Thread-9
get unlock      时间为1508336856014 ThreadName=Thread-9
有可能☆☆连续  时间为1508336856014 ThreadName=Thread-9
 */