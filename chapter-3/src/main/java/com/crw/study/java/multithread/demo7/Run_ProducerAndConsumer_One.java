package com.crw.study.java.multithread.demo7;

/**
 * P158
 * 生产者/消费者模式,一生产一消费：操作值
 */
public class Run_ProducerAndConsumer_One {
    public static void main(String[] args) {
        String lock = new String("");
        Producer producer = new Producer(lock);
        Consumer consumer = new Consumer(lock);
        ThreadP p = new ThreadP(producer);
        ThreadC c = new ThreadC(consumer);
        p.start();
        c.start();
    }
}


/*
输出：
set的值是1508165915030_6818465902317
get的值是1508165915030_6818465902317
set的值是1508165915030_6818465921265
get的值是1508165915030_6818465921265
set的值是1508165915030_6818465941397
get的值是1508165915030_6818465941397
set的值是1508165915030_6818465971399
get的值是1508165915030_6818465971399
set的值是1508165915030_6818465994295
get的值是1508165915030_6818465994295
set的值是1508165915030_6818466016401
get的值是1508165915030_6818466016401
set的值是1508165915030_6818466039691
get的值是1508165915030_6818466039691
set的值是1508165915030_6818466058639
get的值是1508165915030_6818466058639
set的值是1508165915030_6818466083904
get的值是1508165915030_6818466083904
set的值是1508165915030_6818466098904
get的值是1508165915030_6818466098904
set的值是1508165915030_6818466132064
get的值是1508165915030_6818466132064
set的值是1508165915030_6818466158907
get的值是1508165915030_6818466158907
set的值是1508165915030_6818466181408
get的值是1508165915030_6818466181408
set的值是1508165915030_6818466203514
get的值是1508165915030_6818466203514
set的值是1508165915030_6818466225620
get的值是1508165915030_6818466225620
set的值是1508165915030_6818466249306
get的值是1508165915030_6818466249306
set的值是1508165915030_6818466272201
get的值是1508165915030_6818466272201
set的值是1508165915030_6818466295097
get的值是1508165915030_6818466295097
set的值是1508165915030_6818466318388
get的值是1508165915030_6818466318388
set的值是1508165915030_6818466338520
get的值是1508165915030_6818466338520
set的值是1508165915030_6818466356679
get的值是1508165915030_6818466356679
set的值是1508165915030_6818466376022
get的值是1508165915030_6818466376022
set的值是1508165915030_6818466396944
 */