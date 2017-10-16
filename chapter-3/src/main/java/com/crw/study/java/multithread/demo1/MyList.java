package com.crw.study.java.multithread.demo1;

import java.util.ArrayList;
import java.util.List;

public class MyList {
    private List list = new ArrayList();

    public void add() {
        list.add("crw");
    }

    public int size() {
        return list.size();
    }
}

