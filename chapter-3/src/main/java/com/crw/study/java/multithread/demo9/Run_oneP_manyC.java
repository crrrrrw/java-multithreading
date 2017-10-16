package com.crw.study.java.multithread.demo9;

/**
 * P167
 * 一生产与多消费
 *
 * if判断存在弊端，条件发生改变时没有得到及时的响应，多个呈wait状态的线程被唤醒
 * 继而执行list.remove(0)出现异常java.lang.IndexOutOfBoundsException
 *
 * if改成while还是会假死，还需notify改成notifyAll
 */
public class Run_oneP_manyC {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        Producer p = new Producer(myStack);
        Consumer c1 = new Consumer(myStack);
        Consumer c2 = new Consumer(myStack);
        Consumer c3 = new Consumer(myStack);
        Consumer c4 = new Consumer(myStack);
        Consumer c5 = new Consumer(myStack);

        P_Thread p_thread = new P_Thread(p);
        p_thread.start();

        C_Thread c_thread1 = new C_Thread(c1);
        C_Thread c_thread2 = new C_Thread(c2);
        C_Thread c_thread3 = new C_Thread(c3);
        C_Thread c_thread4 = new C_Thread(c4);
        C_Thread c_thread5 = new C_Thread(c5);

        c_thread1.start();
        c_thread2.start();
        c_thread3.start();
        c_thread4.start();
        c_thread5.start();

    }
}

/*
输出：
push = 1
pop = 0  Mystack的pop方法中 线程Thread-3
pop = 0.030470774476863638  Thread-3  Consumer的popService方法中打印pop返回值
pop操作中的： Thread-4 线程呈wait状态
pop操作中的： Thread-5 线程呈wait状态
push = 1
push操作中的： Thread-0 线程呈wait状态
pop = 0  Mystack的pop方法中 线程Thread-2
pop = 0.9950003767578813  Thread-2  Consumer的popService方法中打印pop返回值
pop操作中的： Thread-1 线程呈wait状态
pop操作中的： Thread-2 线程呈wait状态
pop操作中的： Thread-3 线程呈wait状态
Exception in thread "Thread-5" Exception in thread "Thread-4" java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
	at java.util.ArrayList.rangeCheck(ArrayList.java:653)
	at java.util.ArrayList.get(ArrayList.java:429)
	at com.crw.study.java.multithread.demo9.MyStack.pop(MyStack.java:30)
	at com.crw.study.java.multithread.demo9.Consumer.popService(Consumer.java:12)
	at com.crw.study.java.multithread.demo9.C_Thread.run(C_Thread.java:14)
java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
	at java.util.ArrayList.rangeCheck(ArrayList.java:653)
	at java.util.ArrayList.get(ArrayList.java:429)
	at com.crw.study.java.multithread.demo9.MyStack.pop(MyStack.java:30)
	at com.crw.study.java.multithread.demo9.Consumer.popService(Consumer.java:12)
	at com.crw.study.java.multithread.demo9.C_Thread.run(C_Thread.java:14)
 */