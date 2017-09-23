package com.crw.study.java.multithread;

/**
 * P26例子
 * 线程的中断状态由interrupted()清除
 */
public class Run9_interrupted02 {
    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        System.out.println("Thread.interrupted()，是否停止1？=" + Thread.interrupted());
        System.out.println("Thread.interrupted()，是否停止2？=" + Thread.interrupted());
        System.out.println("end");
    }
}

/*
输出：
Thread.interrupted()，是否停止1？=true
Thread.interrupted()，是否停止2？=false
end

 */
/*
测试当前线程是否已经中断。线程的中断状态 由该方法清除。
换句话说，如果连续两次调用该方法，则第二次调用将返回 false（在第一次调用已清除了其中断状态之后，且第二次调用检验完中断状态前，当前线程再次中断的情况除外）。

返回：
如果当前线程已经中断，则返回 true；否则返回 false。
 */
/*
源码：
```
    public static boolean interrupted() {
        return currentThread().isInterrupted(true);
    }

    private native boolean isInterrupted(boolean ClearInterrupted);
```
可以看出，中断的是当前线程，并且清除了标记
 */