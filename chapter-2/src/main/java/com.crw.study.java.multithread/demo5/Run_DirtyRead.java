package com.crw.study.java.multithread.demo5;

/**
 * p64 脏读
 */
public class Run_DirtyRead {
    public static void main(String[] args) {
        try {
            PublicVar publicVarRef = new PublicVar();
            ThreadA thread = new ThreadA(publicVarRef);
            thread.start();
            Thread.sleep(200);
            publicVarRef.getValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
public void getValue() 方法不加 synchronized
输出：
getValue method thread name=main username=B password=AA
setValue method thread name=Thread-0 username=B password=BB
 */
/*
public void getValue() 方法加 synchronized
输出：
setValue method thread name=Thread-0 username=B password=BB
getValue method thread name=main username=B password=BB
 */