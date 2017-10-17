package com.crw.study.java.multithread.demo14;

/**
 * P180
 * join示例,阻塞当前线程z，使join所属的线程对象x正常执行run()方法,执行完在继续当前线程z后面的代码
 */
public class Run_join {
    public static void main(String[] args) {
        try {
            Run_Thread t = new Run_Thread();
            t.start();
            t.join();
            System.out.println("thread执行完后在会打印这句话");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class Run_Thread extends Thread {
        @Override
        public void run() {
            try {
                int secondValue = (int) (Math.random() * 10000);
                System.out.println(secondValue);
                Thread.sleep(secondValue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


/*
输出：
6706
thread执行完后在会打印这句话
 */