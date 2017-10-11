package com.crw.study.java.multithread.demo8;

/**
 * P71
 * 同步不具继承性
 */
public class Run_synNotExtends {
    public static void main(String[] args) {
        Sub sub = new Sub();
        MyThread a = new MyThread(sub);
        a.setName("A");
        a.start();
        MyThread b = new MyThread(sub);
        b.setName("B");
        b.start();
    }
}

/*
Sub的testMethod不加synchronized
输出:
threadName= A in sub 下一步 sleep begin time =1507732949816
threadName= B in sub 下一步 sleep begin time =1507732949816
threadName= B in sub 下一步 sleep end time =1507732951816
threadName= A in sub 下一步 sleep end time =1507732951816
threadName= B in main 下一步 sleep begin time =1507732951816
threadName= B in main 下一步 sleep end time =1507732956817
threadName= A in main 下一步 sleep begin time =1507732956817
threadName= A in main 下一步 sleep end time =1507732961817

--------------------
Sub的testMethod加synchronized
输出:
threadName= A in sub 下一步 sleep begin time =1507732990798
threadName= A in sub 下一步 sleep end time =1507732992800
threadName= A in main 下一步 sleep begin time =1507732992800
threadName= A in main 下一步 sleep end time =1507732997800
threadName= B in sub 下一步 sleep begin time =1507732997800
threadName= B in sub 下一步 sleep end time =1507732999800
threadName= B in main 下一步 sleep begin time =1507732999800
threadName= B in main 下一步 sleep end time =1507733004800

 */