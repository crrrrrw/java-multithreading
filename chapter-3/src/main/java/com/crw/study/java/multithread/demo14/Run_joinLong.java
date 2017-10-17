package com.crw.study.java.multithread.demo14;

/**
 * P183
 * join(long)设定等待的时间
 * join(long)和sleep(long)运行效果并无区别，但对同步的处理不同。
 */
public class Run_joinLong {
    public static void main(String[] args) {
        try {
            Run_Thread thread = new Run_Thread();
            thread.start();
            thread.join(2000);//只等2秒
            //Thread.sleep(2000);
            System.out.println("end timer=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Run_Thread extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("begin timer=" + System.currentTimeMillis());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


/*
输出：
begin timer=1508249440622
end timer=1508249442622
 */