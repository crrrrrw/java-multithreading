package com.crw.study.java.multithread;

/**
 * P18
 * isAlive()
 */
class MyThread7 extends Thread {
    @Override
    public void run() {
        System.out.println("run=" + this.isAlive());
    }
}

public class Run4_isAlive01 {
    public static void main(String[] args) throws InterruptedException {
        MyThread7 myThread7 = new MyThread7();
        System.out.println("begin == " + myThread7.isAlive());
        myThread7.start();
        // Thread.sleep(1000);
        System.out.println("end == " + myThread7.isAlive());
    }

}

/*
输出：
begin == false
end == true
run=true

--------------
Thread.sleep(1000);

输出：
begin == false
run=true
end == false

*/

