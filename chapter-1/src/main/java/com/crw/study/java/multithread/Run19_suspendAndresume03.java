package com.crw.study.java.multithread;

/**
 * P39
 * suspend独占锁问题,println()
 */

class MyThread18 extends Thread {
    private long i = 0;

    @Override
    public void run() {
        while (true) {
            i++;
            System.out.println(i);
        }
    }
}

public class Run19_suspendAndresume03 {
    public static void main(String[] args) {
        try {
            MyThread18 myThread18 = new MyThread18();
            myThread18.start();
            Thread.sleep(1000);
            System.out.println("main before myThread18.suspend()!");
            myThread18.suspend();
            System.out.println("main end!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
输出：
162495
162496
162497
162498
162499
162500
main before myThread18.suspend()!
162501
162502
162503

 */
/*
未打印main end!
原因：当程序运行到println()方法内部停止时，同步锁未被释放。
这导致当前PrintStream对象的println()方法一直呈“暂停”状态，并且“锁未释放”，
而main()方法中的代码 System.out.println("main end!"); 迟迟不能打印。
```
    public void println(String x) {
        synchronized (this) {
            print(x);
            newLine();
        }
    }
```
 */