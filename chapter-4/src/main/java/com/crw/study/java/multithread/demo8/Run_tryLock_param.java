package com.crw.study.java.multithread.demo8;

/**
 * P229
 * 测试方法boolean tryLock(long timeout,TimeUnit unit)
 * 作用：如果锁定在给定等待时间内没有被另一个线程保持，且当前线程未被中断，则获取该锁定
 */
public class Run_tryLock_param {
    public static void main(String[] args) {
        final Service4 service = new Service4();
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 调用waitMethod时间:" + System.currentTimeMillis());
                service.waitMethod();
            }
        };

        Thread threadA = new Thread(runnable);
        threadA.setName("A");
        threadA.start();

        Thread threadB = new Thread(runnable);
        threadB.setName("B");
        threadB.start();
    }
}

/*
输出：
B 调用waitMethod时间:1508423117464
A 调用waitMethod时间:1508423117464
B获得锁的时间:1508423117465
A没有获得锁

-------------------------
A 调用waitMethod时间:1508423090752
B 调用waitMethod时间:1508423090752
A获得锁的时间:1508423090753
B没有获得锁
 */