package com.crw.study.java.multithread.demo11;

public class MyService {

    /*public MyOnelist addServiceMethod(MyOnelist list, String data) {
        try {
            if (list.getSize() < 1) {
                Thread.sleep(2000);
                list.add(data);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }*/

    public MyOnelist addServiceMethod(MyOnelist list, String data) {
        try {
            synchronized (list) {
                if (list.getSize() < 1) {
                    Thread.sleep(2000);
                    list.add(data);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }

}
