package com.crw.study.java.multithread.demo1;

public class ThreadB extends Thread {
    private MyList list;

    public ThreadB(MyList list) {
        super();
        this.list = list;
    }

    @Override
    public void run() {
        try {
            while (true) {
                //System.out.println("in b while: "+list.size());
                //synchronized ("any"){}
                if (list.size() == 5) {
                    System.out.println("达到size了，线程b要退出了");
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
