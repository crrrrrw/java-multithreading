package com.crw.study.java.multithread;

/**
 * P27例子
 * isInterrupted()，不清除状态标记
 */

public class Run10_isInterrupted {
    public static void main(String[] args) {
        try {
            MyThread9 myThread9 = new MyThread9();
            myThread9.start();
            Thread.sleep(100);
            myThread9.interrupt();
            System.out.println("Thread.isInterrupted()，是否停止1？=" + myThread9.isInterrupted());
            System.out.println("Thread.isInterrupted()，是否停止2？=" + myThread9.isInterrupted());
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end");
    }
}

/*
输出节选：
i=17596
i=17597
i=17598
i=17599
Thread.interrupted()，是否停止1？=true
Thread.interrupted()，是否停止2？=true
end
i=17600
i=17601
i=17602
 */
/*
源码：
```
    public boolean isInterrupted() {
        return isInterrupted(false);
    }

    private native boolean isInterrupted(boolean ClearInterrupted);
```
可以看出isInterrupted()不是static的。并且不清除标记。

 */