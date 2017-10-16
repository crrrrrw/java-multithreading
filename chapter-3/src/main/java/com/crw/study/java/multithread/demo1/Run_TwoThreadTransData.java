package com.crw.study.java.multithread.demo1;

/**
 * P134
 * 不使用等待/通知机制实现线程间通信
 *
 * 使用sleep()结合while(true)死循环法来实现线程间通信。
 * 这里有可见性的问题，并不一定能看到线程b退出。
 */
public class Run_TwoThreadTransData {
    public static void main(String[] args) {
        MyList service = new MyList();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
    }

}


/*
在ThreadB的run方法while里加上synchronized ("any"){}

输出：
添加了1元素
添加了2元素
添加了3元素
添加了4元素
添加了5元素
达到size了，线程b要退出了
java.lang.InterruptedException
	at com.crw.study.java.multithread.demo1.ThreadB.run(ThreadB.java:19)
添加了6元素
添加了7元素
添加了8元素
添加了9元素
添加了10元素


----------------
若不加synchronized ("any"){}

输出：
添加了1元素
添加了2元素
添加了3元素
添加了4元素
添加了5元素
添加了6元素
添加了7元素
添加了8元素
添加了9元素
添加了10元素
 */