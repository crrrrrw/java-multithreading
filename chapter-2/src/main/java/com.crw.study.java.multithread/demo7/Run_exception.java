package com.crw.study.java.multithread.demo7;

/**
 * P68
 * 出现异常，锁自动释放
 */
public class Run_exception {
    public static void main(String[] args) {

        try {
            Service service = new Service();
            ThreadA a = new ThreadA("a", service);
            a.start();
            Thread.sleep(500);
            ThreadB b = new ThreadB("b", service);
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


/*
输出：
ThreadName=a run beginTime=1507732375675
Exception in thread "a" ThreadName=a run exceptionTime=1507732376844
Thread b run Time=1507732376844
java.lang.NumberFormatException: For input string: "a"
	at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
	at java.lang.Integer.parseInt(Integer.java:580)
	at java.lang.Integer.parseInt(Integer.java:615)
	at com.crw.study.java.multithread.demo7.Service1.testMethod(Service1.java:12)
	at com.crw.study.java.multithread.demo7.ThreadA1.run(ThreadA1.java:13)

---------------

ThreadName=a run beginTime=1507732419639
ThreadName=a run exceptionTime=1507732420376
Thread b run Time=1507732420377
Exception in thread "a" java.lang.NumberFormatException: For input string: "a"
	at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
	at java.lang.Integer.parseInt(Integer.java:580)
	at java.lang.Integer.parseInt(Integer.java:615)
	at com.crw.study.java.multithread.demo7.Service1.testMethod(Service1.java:12)
	at com.crw.study.java.multithread.demo7.ThreadA1.run(ThreadA1.java:13)



---------


ThreadName=a run beginTime=1507732731392
Exception in thread "a" java.lang.NumberFormatException: For input string: "a"
	at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
	at java.lang.Integer.parseInt(Integer.java:580)
	at java.lang.Integer.parseInt(Integer.java:615)
	at com.crw.study.java.multithread.demo7.Service1.testMethod(Service1.java:12)
	at com.crw.study.java.multithread.demo7.ThreadA1.run(ThreadA1.java:13)
ThreadName=a run exceptionTime=1507732731409
Thread b run Time=1507732731894
 */