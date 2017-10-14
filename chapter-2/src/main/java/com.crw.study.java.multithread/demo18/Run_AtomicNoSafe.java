package com.crw.study.java.multithread.demo18;

/**
 * P128
 * 使用原子类进行i++操作
 */
public class Run_AtomicNoSafe {
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        for (int i = 0; i <5; i++) {
            new MyThread2(service).start();
        }
        Thread.sleep(1000);
        System.out.println(service.aiRef.get());
    }
}

/*
累加正确，但是打印顺序出错，因为虽然addAndGet是原子的，但是方法之间不是原子的
输出：
Thread-1加了100以后的是：200
Thread-2加了100以后的是：400
Thread-3加了100以后的是：300
Thread-0加了100以后的是：100
Thread-4加了100以后的是：503
505

--------------------------------
加同步后
输出：
Thread-0加了100以后的是：100
Thread-1加了100以后的是：201
Thread-2加了100以后的是：302
Thread-4加了100以后的是：403
Thread-3加了100以后的是：504
505
 */