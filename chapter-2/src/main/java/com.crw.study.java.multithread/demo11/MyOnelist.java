package com.crw.study.java.multithread.demo11;

import java.util.ArrayList;
import java.util.List;

public class MyOnelist {

    private List list = new ArrayList();

    synchronized public void add(String data) {
        list.add(data);
    }

    synchronized public int getSize() {
        return list.size();
    }
}
