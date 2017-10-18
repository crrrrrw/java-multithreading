package com.crw.study.java.multithread.demo16;

import java.util.Date;

public class InheritableThreadLocalExt2 extends InheritableThreadLocal {
    @Override
    protected Object initialValue() {
        return new Date().getTime();
    }

    @Override
    protected Object childValue(Object parentValue) {
        return parentValue + "我在子线程加的~";
    }
}
