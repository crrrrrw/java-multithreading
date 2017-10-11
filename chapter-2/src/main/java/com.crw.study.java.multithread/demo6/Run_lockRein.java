package com.crw.study.java.multithread.demo6;

/**
 * P67
 * “可重入锁”的概念是：自己可以再次获取自己的内部锁。
 * synchronized锁重入，支持继承
 * 此实验说明，当存在父子继承关系时，子类完全可以通过“可重入锁”调用父类的同步方法的。
 */
public class Run_lockRein {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                Sub sub = new Sub();
                sub.operateIinSub();
            }
        };
        t.start();

    }

}

/*
输出：
sub print i=9
main print i=8
sub print i=7
main print i=6
sub print i=5
main print i=4
sub print i=3
main print i=2
sub print i=1
main print i=0
 */
