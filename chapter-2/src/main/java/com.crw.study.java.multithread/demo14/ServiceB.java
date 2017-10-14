package com.crw.study.java.multithread.demo14;

public class ServiceB {
    public static void print(Object object) {
        try {
            synchronized (object) {
                while (true) {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(500);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
