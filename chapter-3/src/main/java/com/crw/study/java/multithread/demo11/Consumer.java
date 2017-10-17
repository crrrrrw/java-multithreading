package com.crw.study.java.multithread.demo11;

public class Consumer {
    private MyStack myStack;

    public Consumer(MyStack myStack) {
        super();
        this.myStack = myStack;
    }

    public void popService() {
        System.out.println("pop = " + myStack.pop() + "  Consumer的popService方法中打印pop返回值");
    }

}
