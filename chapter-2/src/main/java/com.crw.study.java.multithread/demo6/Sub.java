package com.crw.study.java.multithread.demo6;

public class Sub extends Main {
    synchronized public void operateIinSub() {
        try {
            while (i > 0) {
                i--;
                System.out.println("sub print i=" + i);
                Thread.sleep(100);
                this.operateIinMain();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
