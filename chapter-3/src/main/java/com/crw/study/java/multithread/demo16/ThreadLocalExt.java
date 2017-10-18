package com.crw.study.java.multithread.demo16;

import java.util.Date;

public class ThreadLocalExt extends ThreadLocal {
    @Override
    protected Object initialValue() {
        return new Date().getTime();
    }
}
