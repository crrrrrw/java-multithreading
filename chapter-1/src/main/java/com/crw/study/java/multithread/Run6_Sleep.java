package com.crw.study.java.multithread;

/**
 * P20~21
 * sleep()方法测试
 * run---同步执行
 * start---异步执行
 * 所以输出顺序有所不同
 */
class MyThread8 extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("run threadName=" + this.currentThread().getName() + " begin");
            Thread.sleep(2000);
            System.out.println("run threadName=" + this.currentThread().getName() + " end");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Run6_Sleep {
    public static void main(String[] args) {
        MyThread8 myThread8 = new MyThread8();
        System.out.println("begin = " + System.currentTimeMillis());
        // myThread8.run();
        myThread8.start();
        System.out.println("end = " + System.currentTimeMillis());
    }
}

/*
myThread6.run();
//myThread6.start();
输出：
begin = 1460340883191
run threadName=main begin
run threadName=main end
end = 1460340885192

-----------------------
//myThread6.run();
myThread6.start();
输出：
begin = 1460341011862
end = 1460341011862
run threadName=Thread-0 begin
run threadName=Thread-0 end

*/