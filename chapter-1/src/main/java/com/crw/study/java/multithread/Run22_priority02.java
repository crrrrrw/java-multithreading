package com.crw.study.java.multithread;

import java.util.Random;

/**
 * P45例子
 * 优先级具有规则性
 */

class MyThread21_1 extends Thread {
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        long addResult = 0;
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 50000; i++) {
                Random random = new Random();
                random.nextInt();
                addResult += i;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("★★★★★ thread1 use time = " + (endTime - beginTime));
    }
}

class MyThread21_2 extends Thread {
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        long addResult = 0;
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 50000; i++) {
                Random random = new Random();
                random.nextInt();
                addResult += i;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("☆☆☆☆☆ thread2 use time = " + (endTime - beginTime));
    }
}

public class Run22_priority02 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            MyThread21_1 myThread21_1 = new MyThread21_1();
            myThread21_1.setPriority(10);
            //myThread21_1.setPriority(1);
            myThread21_1.start();
            MyThread21_2 myThread21_2 = new MyThread21_2();
            //myThread21_2.setPriority(10);
            myThread21_2.setPriority(1);
            myThread21_2.start();
        }
    }
}


/*
myThread21_1.setPriority(10);
myThread21_2.setPriority(1);
输出：
★★★★★ thread1 use time = 258
★★★★★ thread1 use time = 277
★★★★★ thread1 use time = 351
★★★★★ thread1 use time = 362
☆☆☆☆☆ thread2 use time = 461
☆☆☆☆☆ thread2 use time = 484
☆☆☆☆☆ thread2 use time = 504
★★★★★ thread1 use time = 511
☆☆☆☆☆ thread2 use time = 522
☆☆☆☆☆ thread2 use time = 523

-------------------------

★★★★★ thread1 use time = 121
★★★★★ thread1 use time = 232
☆☆☆☆☆ thread2 use time = 268
☆☆☆☆☆ thread2 use time = 292
★★★★★ thread1 use time = 322
☆☆☆☆☆ thread2 use time = 325
★★★★★ thread1 use time = 387
☆☆☆☆☆ thread2 use time = 390
★★★★★ thread1 use time = 395
☆☆☆☆☆ thread2 use time = 409


----------------------------------------------------
----------------------------------------------------
myThread21_1.setPriority(1);
myThread21_2.setPriority(10);
输出：

☆☆☆☆☆ thread2 use time = 301
☆☆☆☆☆ thread2 use time = 333
★★★★★ thread1 use time = 374
☆☆☆☆☆ thread2 use time = 399
☆☆☆☆☆ thread2 use time = 400
★★★★★ thread1 use time = 450
☆☆☆☆☆ thread2 use time = 496
★★★★★ thread1 use time = 526
★★★★★ thread1 use time = 531
★★★★★ thread1 use time = 531

---------------

☆☆☆☆☆ thread2 use time = 354
☆☆☆☆☆ thread2 use time = 381
☆☆☆☆☆ thread2 use time = 435
★★★★★ thread1 use time = 440
☆☆☆☆☆ thread2 use time = 483
☆☆☆☆☆ thread2 use time = 519
★★★★★ thread1 use time = 530
★★★★★ thread1 use time = 562
★★★★★ thread1 use time = 561
★★★★★ thread1 use time = 562

 */