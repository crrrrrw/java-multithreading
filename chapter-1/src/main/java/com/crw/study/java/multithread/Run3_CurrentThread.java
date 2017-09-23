package com.crw.study.java.multithread;

/**
 * currentThread(), getName() 方法
 */
public class Run3_CurrentThread {

    public static void main(String[] args) {
        MyThread6 myThread6 = new MyThread6();
        myThread6.start();
        //myThread6.run();

        // ===================================
        CountOperate c = new CountOperate();
        Thread t1 = new Thread(c);
        t1.setName("A");
        t1.start();
    }
}

/**
 * p16
 */
class MyThread6 extends Thread {
    public MyThread6() {
        System.out.println("构造方法打印:" + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run方法打印：" + Thread.currentThread().getName());
    }
}


/*
myThread6.start();
//myThread6.run();
输出：
构造方法打印:main
run方法打印：Thread-0

--------------------
//myThread6.start();
myThread6.run();
输出：
构造方法打印:main
run方法打印：main

*/

/**
 * P17小例子
 * this.getName()！=Thread.currentThread().getName()，这是两个概念。
 */
class CountOperate extends Thread {
    public CountOperate() {
        System.out.println("CountOperate---begin");
        System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
        System.out.println("this.getName()=" + this.getName());
        System.out.println("CountOperate---end");
    }

    @Override
    public void run() {
        System.out.println("run---begin");
        System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
        System.out.println("this.getName()=" + this.getName());
        System.out.println("run---end");
    }
}

/*
输出：
CountOperate---begin
Thread.currentThread().getName()=main
this.getName()=Thread-0
CountOperate---end
run---begin
Thread.currentThread().getName()=A
this.getName()=Thread-0
run---end
 */
/*
 因为this代表的是CountOpera这个对象，this.getName()其实就是最简单的方法调用，然而当前对象里面没有这个方法，
 又因为继承了Thread方法，所以它执行的就是Thread父类的方法，父类方法如下：
 ```
    public final String getName() {
        return new String(name, true);
    }
 ```
 name来自：
 ```
    public Thread() {
        init(null, null, "Thread-" + nextThreadNum(), 0);
    }

    private void init(ThreadGroup g, Runnable target, String name,
                      long stackSize) {
        init(g, target, name, stackSize, null);
    }
 ```

 重点还是这句首先要清楚t1和c是两个完全不同的对象，他俩之间唯一的关系就是把c传递给t1对象仅仅是为了让t1调用c对象的run方法
 */

/*
将线程对象以构造参数的方式传递给Thread对象进行start()启动线程，我们直接启动的线程实际是t1，而作为构造参数的myThread，赋给Thread类中的属性target，之后在Thread的run方法中调用target.run()；
此时Thread.currentThread()是Thread的引用t1, 而this依旧是CountOperate的引用，所以是不一样的，打印的内容也不一样
 */