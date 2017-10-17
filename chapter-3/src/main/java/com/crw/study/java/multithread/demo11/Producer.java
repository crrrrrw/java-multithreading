package com.crw.study.java.multithread.demo11;

public class Producer {
    private MyStack myStack;

    public Producer(MyStack myStack) {
        super();
        this.myStack = myStack;
    }

    public void pushService() {
        myStack.push();
    }

}
