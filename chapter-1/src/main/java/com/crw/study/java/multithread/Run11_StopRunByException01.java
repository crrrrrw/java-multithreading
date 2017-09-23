package com.crw.study.java.multithread;

/**
 * p28 未通过抛异常停止程序继续运行
 */
public class Run11_StopRunByException01 {
    public static void main(String[] args) {
        try {
            MyThread11 myThread11 = new MyThread11();
            myThread11.start();
            Thread.sleep(2000);
            myThread11.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}

class MyThread11 extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
             if(this.isInterrupted()) {
                 System.out.println("已经是停止状态了！我要退出了！");
                 break;
             }
            System.out.println("i=" + (i + 1));
        }
        System.out.println("我被输出，如果此代码是for又继续运行，线程并未停止！");
    }
}

/*
输出截取：
i=497132
i=497133
i=497134
i=497135
i=497136
end
已经是停止状态了！我要退出了！
我被输出，如果此代码是for又继续运行，线程并未停止！
 */
