package com.crw.study.java.multithread.demo12;

import java.io.PipedInputStream;

public class ThreadRead extends Thread {
    private ReadData read;
    private PipedInputStream input;

    public ThreadRead(ReadData read, PipedInputStream input) {
        super();
        this.input = input;
        this.read = read;
    }

    @Override
    public void run() {
        read.readMethod(input);
    }
}
