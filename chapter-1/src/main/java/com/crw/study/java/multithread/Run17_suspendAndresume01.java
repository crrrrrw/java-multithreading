package com.crw.study.java.multithread;


/**
 * P36例子
 * 暂停线程
 * 使用suspend()暂停线程，resume()恢复线程运行
 */
class MyThread17 extends Thread {
    private long i = 0;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true) {
            i++;
        }
    }
}

public class Run17_suspendAndresume01 {
    public static void main(String[] args) {
        try {
            MyThread17 myThread17 = new MyThread17();
            myThread17.start();
            Thread.sleep(5000);
            //A段
            myThread17.suspend();
            System.out.println("A= " + System.currentTimeMillis() + " i=" + myThread17.getI());
            Thread.sleep(5000);
            System.out.println("A= " + System.currentTimeMillis() + " i=" + myThread17.getI());

            //B段
            myThread17.resume();
            Thread.sleep(5000);
            //C段
            myThread17.suspend();
            System.out.println("B= " + System.currentTimeMillis() + " i=" + myThread17.getI());
            Thread.sleep(5000);
            System.out.println("B= " + System.currentTimeMillis() + " i=" + myThread17.getI());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}

/*
输出：
A= 1506151693018 i=2749528065
A= 1506151698018 i=2749528065
B= 1506151703019 i=5459382362
B= 1506151708019 i=5459382362
end
 */