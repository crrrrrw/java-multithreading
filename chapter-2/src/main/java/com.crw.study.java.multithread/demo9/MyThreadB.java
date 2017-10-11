package com.crw.study.java.multithread.demo9;

public class MyThreadB extends Thread {
    private TaskB taskB;

    public MyThreadB(TaskB taskB) {
        super();
        this.taskB = taskB;
    }

    @Override
    public void run() {
        super.run();
        if (this.getName().equals("c")) {
            CommonUtils.beginTime1 = System.currentTimeMillis();
            taskB.doLongTimeTask();
            CommonUtils.endTime1 = System.currentTimeMillis();
        } else if (this.getName().equals("d")) {
            CommonUtils.beginTime2 = System.currentTimeMillis();
            taskB.doLongTimeTask();
            CommonUtils.endTime2 = System.currentTimeMillis();
        } else {
            System.out.println("unexpected name");
        }

    }
}
